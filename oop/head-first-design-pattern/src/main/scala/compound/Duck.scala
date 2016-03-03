package compound

/**
  * Created by michael on 2/24/16.
  */
class MallardDuck extends Quackable {
  private val observable = new Observable(this)
  override def quack(): Unit = {
    println("Quack")
    notifyObserver()
  }

  override def registerObserver(observer: Observer): Unit = {
    observable.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    observable.notifyObserver()
  }

  override def toString: String = "Mallard Duck"
}

class RedheadDuck extends Quackable {
  private val observable = new Observable(this)
  override def quack(): Unit = {
    println("Quack")
    notifyObserver()
  }

  override def registerObserver(observer: Observer): Unit = {
    observable.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    observable.notifyObserver()
  }

  override def toString: String = "Redhead Duck"
}

class DuckCall extends Quackable {
  private val observable = new Observable(this)
  override def quack(): Unit = {
    println("Kwak")
    notifyObserver()
  }

  override def registerObserver(observer: Observer): Unit = {
    observable.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    observable.notifyObserver()
  }

  override def toString: String = "Duck Call"
}

class RubberDuck extends Quackable {
  private val observable = new Observable(this)
  override def quack(): Unit = {
    println("Squeak")
    notifyObserver()
  }

  override def registerObserver(observer: Observer): Unit = {
    observable.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    observable.notifyObserver()
  }

  override def toString: String = "Rubber Duck"
}



