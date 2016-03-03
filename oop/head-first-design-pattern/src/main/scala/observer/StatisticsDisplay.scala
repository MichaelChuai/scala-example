package observer

/**
  * Created by michael on 2/23/16.
  */
class StatisticsDisplay(weatherData: WeatherData) extends Observer with DisplayElement {
  private var maxTemp: Double = 0.0f
  private var minTemp: Double = 200
  private var tempSum: Double = 0.0f
  private var numReadings: Double = 0

  weatherData.registerObserver(this)

  override def update(temp: Double, humidity: Double, pressure: Double): Unit =  {
    tempSum += temp
    numReadings += 1
    if (temp > maxTemp) {
      maxTemp = temp
    }
    if (temp < minTemp) {
      minTemp = temp
    }
    display()
  }

  override def display(): Unit = {
    println(s"Avg/Max/Min temperature = ${tempSum / numReadings}/$maxTemp/$minTemp")
  }

}
