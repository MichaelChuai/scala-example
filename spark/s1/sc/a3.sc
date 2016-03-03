val sc: org.apache.spark.SparkContext

import org.apache.spark.rdd._
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.mllib.recommendation._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer

val rawUserArtistData = sc.textFile(MyUtil.getPath("ds/user_artist_data.txt"))
val rawArtistData = sc.textFile(MyUtil.getPath("ds/artist_data.txt"))
val artistByID = rawArtistData flatMap { line =>
  val (id, name) = line.span(_ != '\t')
  if (name.isEmpty) {
    None
  } else {
    try {
      Some((id.toInt, name.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }
}
val rawArtistAlias = sc.textFile(MyUtil.getPath("ds/artist_alias.txt"))
val artistAlias = rawArtistAlias.flatMap{ line =>
  val tokens = line.split("\t")
  if (tokens(0).isEmpty) {
    None
  } else {
    Some((tokens(0).toInt, tokens(1).toInt))
  }
}.collectAsMap()

val bArtistAlias = sc.broadcast(artistAlias)
val trainData = rawUserArtistData map { line =>
  val Array(userID, artistID, count) = line.split(" ").map(_.toInt)
  val finalArtistID = bArtistAlias.value.getOrElse(artistID, artistID)
  Rating(userID, finalArtistID, count)
} cache()
val model = ALS.trainImplicit(trainData, 10, 5, 0.01, 1.0)
//model.userFeatures.mapValues(_.mkString(", ")).first()

val rawArtistsForUser = rawUserArtistData map (_.split(" ")) filter {
  case Array(user, _, _) => user.toInt == 2093760
}
val existingProducts = rawArtistsForUser.map{
  case Array(_, artist, _) => artist.toInt
}.collect.toSet

artistByID.filter{
  case (id, name) => existingProducts.contains(id)
}.values.collect

val recom = model.recommendProducts(2093760, 5)
val recomProID = recom.map(_.product).toSet
artistByID.filter{
  case (id, name) => recomProID.contains(id)
}.values.collect

def buildRatings(
                  rawUserArtistData: RDD[String],
                  bArtistAlias: Broadcast[Map[Int,Int]]) = {
  rawUserArtistData.map { line =>
    val Array(userID, artistID, count) = line.split(' ').map(_.toInt)
    val finalArtistID = bArtistAlias.value.getOrElse(artistID, artistID)
    Rating(userID, finalArtistID, count)
  }
}

def areaUnderCurve(
                    positiveData: RDD[Rating],
                    bAllItemIDs: Broadcast[Array[Int]],
                    predictFunction: (RDD[(Int,Int)] => RDD[Rating])) = {
  // What this actually computes is AUC, per user. The result is actually something
  // that might be called "mean AUC".

  // Take held-out data as the "positive", and map to tuples
  val positiveUserProducts = positiveData.map(r => (r.user, r.product))
  // Make predictions for each of them, including a numeric score, and gather by user
  val positivePredictions = predictFunction(positiveUserProducts).groupBy(_.user)

  // BinaryClassificationMetrics.areaUnderROC is not used here since there are really lots of
  // small AUC problems, and it would be inefficient, when a direct computation is available.

  // Create a set of "negative" products for each user. These are randomly chosen
  // from among all of the other items, excluding those that are "positive" for the user.
  val negativeUserProducts = positiveUserProducts.groupByKey().mapPartitions {
    // mapPartitions operates on many (user,positive-items) pairs at once
    userIDAndPosItemIDs => {
      // Init an RNG and the item IDs set once for partition
      val random = new Random()
      val allItemIDs = bAllItemIDs.value
      userIDAndPosItemIDs.map { case (userID, posItemIDs) =>
        val posItemIDSet = posItemIDs.toSet
        val negative = new ArrayBuffer[Int]()
        var i = 0
        // Keep about as many negative examples per user as positive.
        // Duplicates are OK
        while (i < allItemIDs.size && negative.size < posItemIDSet.size) {
          val itemID = allItemIDs(random.nextInt(allItemIDs.size))
          if (!posItemIDSet.contains(itemID)) {
            negative += itemID
          }
          i += 1
        }
        // Result is a collection of (user,negative-item) tuples
        negative.map(itemID => (userID, itemID))
      }
    }
  }.flatMap(t => t)
  // flatMap breaks the collections above down into one big set of tuples

  // Make predictions on the rest:
  val negativePredictions = predictFunction(negativeUserProducts).groupBy(_.user)

  // Join positive and negative by user
  positivePredictions.join(negativePredictions).values.map {
    case (positiveRatings, negativeRatings) =>
      // AUC may be viewed as the probability that a random positive item scores
      // higher than a random negative one. Here the proportion of all positive-negative
      // pairs that are correctly ranked is computed. The result is equal to the AUC metric.
      var correct = 0L
      var total = 0L
      // For each pairing,
      for (positive <- positiveRatings;
           negative <- negativeRatings) {
        // Count the correctly-ranked pairs
        if (positive.rating > negative.rating) {
          correct += 1
        }
        total += 1
      }
      // Return AUC: fraction of pairs ranked correctly
      correct.toDouble / total
  }.mean() // Return mean AUC over users
}

