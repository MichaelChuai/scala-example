package strategy

/**
  * Created by michael on 2/22/16.
  */
class MallardDuck extends Duck {
  override var flyBehavior: FlyBehavior = new FlyWithWings
  override var quackBehavior: QuackBehavior = new Quack
  override def display(): Unit = {
    println("I'm a real Mallard duck")
  }
}
