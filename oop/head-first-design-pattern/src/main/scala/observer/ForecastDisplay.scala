package observer

/**
  * Created by michael on 2/23/16.
  */
class ForecastDisplay(weatherData: WeatherData) extends Observer with DisplayElement {
  private var currentPressure: Double = 29.92f
  private var lastPressure: Double = 0

  weatherData.registerObserver(this)

  override def update(temp: Double, humidity: Double, pressure: Double): Unit = {
    lastPressure = currentPressure
    currentPressure = pressure
    display()
  }

  override def display(): Unit = {
    print("Forecast: ")
    if (currentPressure > lastPressure) {
      println("Improving weather on the way!")
    } else if (currentPressure == lastPressure) {
      println("More of the same")
    } else if (currentPressure < lastPressure) {
      println("Watch out for cooler, rainy weather")
    }
  }
}
