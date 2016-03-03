package strategy

/**
  * Created by michael on 2/22/16.
  */
class ModelDuck extends Duck {
  override var flyBehavior: FlyBehavior = new FlyNoWay
  override var quackBehavior: QuackBehavior = new Quack

  override def display(): Unit = {
    println("I'm a model duck")
  }
}
