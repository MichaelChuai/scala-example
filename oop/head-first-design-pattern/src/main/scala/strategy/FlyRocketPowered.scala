package strategy

/**
  * Created by michael on 2/22/16.
  */
class FlyRocketPowered extends FlyBehavior {
  override def fly(): Unit = {
    println("I'm flying with a rocket")
  }
}
