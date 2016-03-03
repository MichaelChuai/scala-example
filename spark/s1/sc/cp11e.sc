val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD

val data = MLUtils.loadLibSVMFile(sc, MyUtil.getPath("data/mllib/sample_binary_classification_data.txt"))

def StratifiedKfold(d: RDD[LabeledPoint], nFold: Int) = {
  val keys = (d map (l => (l.label, l)) keys).distinct.collect
  keys map { key =>
    d.filter(k => k.label == key)
  } map { dl =>
    MLUtils.kFold(dl, nFold, 0)
  } reduce { (a1, a2) =>
    a1 zip a2 map { case (a1t, a2t) =>
      (a1t._1 union a2t._1, a1t._2 union a2t._2)
    }
  }
}

//val d = MLUtils.kFold(data, 5, 0)
val dt = StratifiedKfold(data, 5)
val logit = new LogisticRegressionWithLBFGS().setIntercept(true).setNumClasses(2)

val genAUC: PartialFunction[(RDD[LabeledPoint], RDD[LabeledPoint]), Double] = {
  case (tr, te) =>
    val model = logit.run(tr)
    model.clearThreshold()
    val predictionAndLabels = te map { case LabeledPoint(label, features) =>
      val prediction = model.predict(features)
      (prediction, label)
    }
    val metrics = new BinaryClassificationMetrics(predictionAndLabels)
    metrics.areaUnderROC
}

import breeze.linalg.DenseVector
import breeze.stats.mean

val p = DenseVector(dt map genAUC)
val k = mean(p)

//val (tr, te) = dt(3)
//val (a1, a2, a3, a4) = (
//tr.filter(s => s.label == 0.0).count(),
//tr.filter(s => s.label == 1.0).count(),
//te.filter(s => s.label == 0.0).count(),
//te.filter(s => s.label == 1.0).count())
