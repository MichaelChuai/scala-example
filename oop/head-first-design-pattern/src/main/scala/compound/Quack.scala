package compound

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/24/16.
  */

trait QuackObservable {
  def registerObserver(observer: Observer): Unit
  def notifyObserver(): Unit
}

class Observable(duck: QuackObservable) extends QuackObservable {
  private val observers: ArrayBuffer[Observer] = ArrayBuffer.empty[Observer]

  override def registerObserver(observer: Observer): Unit = {
    observers.append(observer)
  }

  override def notifyObserver(): Unit = {
    observers foreach (_.update(duck))
  }
}

trait Observer {
  def update(duck: QuackObservable)
}

trait Quackable extends QuackObservable {
  def quack(): Unit
}

class QuackCounter(duck: Quackable) extends Quackable {
  override def quack(): Unit = {
    duck.quack()
    QuackCounter.numberOfQuacks += 1
  }
  override def registerObserver(observer: Observer): Unit = {
    duck.registerObserver(observer)
  }
  override def notifyObserver(): Unit = {
    duck.notifyObserver()
  }
}

object QuackCounter {
  private var numberOfQuacks: Int = 0
  def getQuacks: Int = numberOfQuacks
}

class Flock extends Quackable {
  private val quackers: ArrayBuffer[Quackable] = ArrayBuffer.empty[Quackable]

  def add(quacker: Quackable): Unit = {
    quackers.append(quacker)
  }

  override def quack(): Unit = {
    quackers foreach (_.quack())
  }

  override def registerObserver(observer: Observer): Unit = {
    quackers foreach (_.registerObserver(observer))
  }
  override def notifyObserver(): Unit = {

  }
}