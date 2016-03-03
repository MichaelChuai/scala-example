package strategy

/**
  * Created by michael on 2/22/16.
  */
trait FlyBehavior {
  def fly(): Unit
}

class FlyWithWings extends FlyBehavior {
  override def fly(): Unit = {
    println("I'm flying")
  }
}

class FlyNoWay extends FlyBehavior {
  override def fly(): Unit = {
    println("I can't fly")
  }
}
