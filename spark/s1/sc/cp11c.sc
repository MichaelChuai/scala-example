val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.feature.{HashingTF, IDF}
import org.apache.spark.mllib.linalg.Vectors

//val sentence = sc.textFile(MyUtil.getPath("data/spam.txt"))
//val tf = new HashingTF(numFeatures = 10000)
//val tfVec = sentence map (e => tf.transform(e.split(" "))) cache
//
//val idf = new IDF()
//val idfModel = idf.fit(tfVec)
//val tfIdfVec = idfModel.transform(tfVec)

import org.apache.spark.mllib.feature.StandardScaler

val vec = List(Vectors.dense(-2.0, 5.0, 1.0), Vectors.dense(2.0, 0, 1.0))
val ds = sc.parallelize(vec)
val scaler = new StandardScaler(withMean = true, withStd = true)
val model = scaler.fit(ds)
val res = model.transform(ds)
