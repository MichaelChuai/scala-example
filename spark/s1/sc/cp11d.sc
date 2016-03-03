val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.evaluation.RegressionMetrics

val data = sc.textFile(MyUtil.getPath("data/mllib/ridge-data/lpsa.data"))

val points: RDD[LabeledPoint] = data map { line =>
  val parts = line.split(",")
  LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(" ") map (_.toDouble)))
} cache

val lr = new LinearRegressionWithSGD().setIntercept(true)
lr.optimizer.setNumIterations(200)
val model = lr.run(points)

println(s"weights: ${model.weights}, intercept: ${model.intercept}")

val valuesAndPreds = points map { point =>
  val prediction = model.predict(point.features)
  (prediction, point.label)
}

val metrics = new RegressionMetrics(valuesAndPreds)
println(s"Training R2: ${metrics.r2}")
