
val c = List(Array((1, 1), (1,1)), Array((2,2),(2,2)))

c reduce { (a, b) =>
  (a zip b) map { case (v1, v2) =>
    (v1._1 + v2._1, v1._2 + v2._2)
  }
}

