package adapter

/**
  * Created by michael on 2/24/16.
  */
trait Turkey {
  def gobble(): Unit
  def fly(): Unit
}

class WildTurkey extends Turkey {
  override def gobble(): Unit = {
  println("Gobble gobble")
}
  override def fly(): Unit = {
  println("I'm flying a short distance")
}
}