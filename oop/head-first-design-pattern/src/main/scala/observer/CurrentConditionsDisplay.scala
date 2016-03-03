package observer

/**
  * Created by michael on 2/23/16.
  */
class CurrentConditionsDisplay(weatherData: Subject) extends Observer with DisplayElement {
  private var temperature: Double = 0
  private var humidity: Double = 0
  weatherData.registerObserver(this)

  override def update(temperature: Double, humidity: Double, pressure: Double): Unit = {
    this.temperature = temperature
    this.humidity = humidity
    display()
  }

  override def display(): Unit = {
    println(s"Current conditions: ${temperature}F degrees and ${humidity}% humidity")
  }

}
