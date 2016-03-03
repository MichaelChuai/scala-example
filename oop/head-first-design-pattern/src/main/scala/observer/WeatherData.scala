package observer

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/22/16.
  */
class WeatherData extends Subject {
  private var temperature: Double = 0
  private var humidity: Double = 0
  private var pressure: Double = 0
  private val observers =  ArrayBuffer[Observer]()

  override def registerObserver(o: Observer): Unit = {
    observers.append(o)
  }

  override def removeObserver(o: Observer): Unit = {
    val i = observers.indexOf(o)
    if (i >= 0) observers.remove(i)
  }

  override def notifyObservers(): Unit = {
    if (changed) {
      observers foreach (_.update(temperature, humidity, pressure))
      changed = false
    }

  }

  def measurementsChanged(): Unit = {
    notifyObservers()
  }

  def setMeasurements(temperature: Double, humidity: Double, pressure: Double): Unit = {
    this.temperature = temperature
    this.humidity = humidity
    this.pressure = pressure
    setChanged()
    measurementsChanged()
  }
  
  def getTemperature = temperature
  def getHumidity = humidity
  def getPressure = pressure

}

