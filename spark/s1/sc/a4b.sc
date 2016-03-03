val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.regression._

val rawData = sc.textFile(MyUtil.getPath("ds/covtype.data"))

val data = rawData map { line =>
  val values = line.split(',').map(_.toDouble)
  val wilderness = values.slice(10, 14).indexOf(1.0).toDouble
  val soil = values.slice(14, 54).indexOf(1.0).toDouble
  val feaVec = Vectors.dense(values.slice(0, 10) :+ wilderness :+ soil)
  val label = values.last - 1
  LabeledPoint(label, feaVec)
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

def getfMetrics(model: RandomForestModel, data: RDD[LabeledPoint]): MulticlassMetrics = {
  val predictionsAndLabels = data map { example =>
    (model.predict(example.features), example.label)
  }
  new MulticlassMetrics(predictionsAndLabels)
}

val evaluations =
  for (impurity <- Array("gini", "entropy");
       depth <- Array(10, 20, 30);
       bins <- Array(40, 300))
    yield {
      val model = DecisionTree.trainClassifier(
        trData, 7, Map(10 -> 4, 11 -> 40), impurity, depth, bins)
      val trAccu = getMetrics(model, trData).precision
      val cvAccu = getMetrics(model, cvData).precision
      ((impurity, depth, bins), (trAccu, cvAccu))
    }

//evaluations.sortBy(_._2._2).reverse.foreach(println)
val model = DecisionTree.trainClassifier(
  trData, 7, Map(10 -> 4, 11 -> 40), "entropy", 30, 300)
val metrics = getMetrics(model, teData)

val fmodel = RandomForest.trainClassifier(
  trData, 7, Map(10 -> 4, 11 -> 40), 20, "auto", "entropy", 30, 300)
val fmetrics = getfMetrics(fmodel, teData)

val input = "2709,125,28,67,23,3224,253,207,61,6094,0,29"
val vec = Vectors.dense(input.split(',').map(_.toDouble))
fmodel.predict(vec)