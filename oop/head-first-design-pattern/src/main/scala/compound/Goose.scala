package compound

/**
  * Created by michael on 2/24/16.
  */
class Goose {
  def honk(): Unit = {
    println("Honk")
  }

  override def toString: String = "Goose"
}

class GooseAdapter(goose: Goose) extends Quackable {
  private val observable = new Observable(this)
  override def quack(): Unit = {
    goose.honk()
    notifyObserver()
  }

  override def registerObserver(observer: Observer): Unit = {
    observable.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    observable.notifyObserver()
  }

  override def toString: String = "Goose pretending to be a Duck"
}