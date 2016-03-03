package adapter

/**
  * Created by michael on 2/24/16.
  */
trait Duck {
  def quack(): Unit
  def fly(): Unit
}

class MallardDuck extends Duck {
  override def quack(): Unit = {
    println("Quack")
  }
  override def fly(): Unit = {
    println("I'm flying")
  }
}

