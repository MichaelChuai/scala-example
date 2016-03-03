val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.regression._

val rawData = sc.textFile(MyUtil.getPath("ds/covtype.data"))

val data = rawData map { line =>
  val values = line.split(',').map(_.toDouble)
  val featureVec = Vectors.dense(values.init)
  val label = values.last - 1
  LabeledPoint(label, featureVec)
}

val Array(trData, cvData, teData) = data.randomSplit(Array(0.8, 0.1, 0.1))

trData.cache
cvData.cache
teData.cache

import org.apache.spark.mllib.evaluation._
import org.apache.spark.mllib.tree._
import org.apache.spark.mllib.tree.model._
import org.apache.spark.rdd._

def getMetrics(model: DecisionTreeModel, data: RDD[LabeledPoint]): MulticlassMetrics = {
  val predictionsAndLabels = data map { example =>
    (model.predict(example.features), example.label)
  }
  new MulticlassMetrics(predictionsAndLabels)
}

val model = DecisionTree.trainClassifier(trData, 7, Map[Int, Int](), "gini", 4, 100)
val metrics = getMetrics(model, cvData)

//(0 until 7) map {
//  cat => (metrics.precision(cat), metrics.recall(cat))
//}


def classProb(data: RDD[LabeledPoint]): Array[Double] = {
  val countsByCat = data.map(_.label).countByValue()
  val counts = countsByCat.toArray.sortBy(_._1).map(_._2)
  counts.map(_.toDouble / counts.sum)
}
val trPriProb = classProb(trData)
val cvPriProb = classProb(cvData)
//trPriProb zip cvPriProb map {
//  case (trProb, cvProb) => trProb * cvProb
//} sum

val evaluations =
  for (impurity <- Array("gini", "entropy");
       depth <- Array(1, 20);
       bins <- Array(10, 300))
    yield {
      val model = DecisionTree.trainClassifier(trData, 7, Map[Int, Int](), impurity, depth, bins)
      val metrics = getMetrics(model, cvData)
      val accu = metrics.precision
      ((impurity, depth, bins), accu)
    }

evaluations.sortBy(_._2).reverse
val model1 = DecisionTree.trainClassifier(trData.union(cvData), 7, Map[Int, Int](), "entropy", 20, 300)
val metrics1 = getMetrics(model1, cvData)
val accu1 = metrics1.precision

val metrics2 = getMetrics(model1, teData)
val accu2 = metrics2.precision


