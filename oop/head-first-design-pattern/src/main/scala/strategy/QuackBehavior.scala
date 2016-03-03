package strategy

/**
  * Created by michael on 2/22/16.
  */
trait QuackBehavior {
  def quack(): Unit
}

class Quack extends QuackBehavior {
  override def quack(): Unit = {
    println("Quack")
  }
}

class MuteQuack extends QuackBehavior {
  override def quack(): Unit = {
    println("<< Slience >>")
  }
}

class Squeak extends QuackBehavior {
  override def quack(): Unit = {
    println("Squeak")
  }
}