package observer

/**
  * Created by michael on 2/22/16.
  */
trait Observer {
  def update(temperature: Double, humidity: Double, pressure: Double): Unit
}

trait Subject {
  protected var changed: Boolean = false
  def registerObserver(o: Observer): Unit
  def removeObserver(o: Observer): Unit
  protected def setChanged(): Unit = {
    changed = true
  }
  protected def clearChanged(): Unit = {
    changed = false
  }
  def notifyObservers(): Unit
}