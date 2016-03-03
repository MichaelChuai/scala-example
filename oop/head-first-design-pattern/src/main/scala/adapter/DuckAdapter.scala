package adapter

import scala.util.Random

/**
  * Created by michael on 2/24/16.
  */
class DuckAdapter(duck: Duck) extends Turkey {
  override def gobble(): Unit = {
    duck.quack()
  }
  override def fly(): Unit = {
    if (Random.nextInt(5) == 0) {
      duck.fly()
    }
  }
}
