val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD


val spam = sc.textFile(MyUtil.getPath("data/spam.txt"))
val ham = sc.textFile(MyUtil.getPath("data/ham.txt"))

val tf = new HashingTF(numFeatures = 10000)
val spamFeatures = spam map (email => tf.transform(email.split(" ")))
val hamFeatures = ham map (email => tf.transform(email.split(" ")))

val posEmp = spamFeatures map (features => LabeledPoint(1, features))
val negEmp = hamFeatures map (features => LabeledPoint(0, features))
val trData = posEmp union negEmp cache

val model = new LogisticRegressionWithSGD().run(trData)

val posTest = tf.transform(
  "O M G GET cheap stuff by sending money to ...".split(" "))
val negTest = tf.transform(
  "Hi Dad, I started studying Spark the other ...".split(" ")
)
println(s"Prediction for positive test example: ${model.predict(posTest)}")
println(s"Prediction for negative test example: ${model.predict(negTest)}")
