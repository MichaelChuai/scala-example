val sc: org.apache.spark.SparkContext

import org.apache.spark.mllib.linalg.Vectors

val denseVec1 = Vectors.dense(1, 2, 3)
val denseVec2 = Vectors.dense(Array(1.0, 2.0, 3.0))

val sparseVec1 = Vectors.sparse(4, Array(0, 2), Array(1.0, 2.0))
