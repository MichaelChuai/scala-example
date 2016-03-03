package strategy

/**
  * Created by michael on 2/22/16.
  */


abstract class Duck {
  protected var flyBehavior: FlyBehavior
  protected var quackBehavior: QuackBehavior

  def display(): Unit

  def performFly(): Unit = {
    flyBehavior.fly()
  }

  def performQuack(): Unit = {
    quackBehavior.quack()
  }

  def swim: Unit = {
    println("All ducks float, even decoys!")
  }

  def setFlyBehavior(fb: FlyBehavior): Unit = {
    flyBehavior = fb
  }

  def setQuackBehavior(qb: QuackBehavior): Unit = {
    quackBehavior = qb
  }
}





