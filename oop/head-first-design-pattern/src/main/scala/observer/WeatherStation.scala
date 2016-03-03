package observer

/**
  * Created by michael on 2/23/16.
  */

object WeatherStation {
  def main1(args: Array[String]) = {
    val weatherData = new WeatherData

    val currentDisplay = new CurrentConditionsDisplay(weatherData)
    val statisticsDisplay = new StatisticsDisplay(weatherData)
    val forecastDisplay = new ForecastDisplay(weatherData)
    val heatIndexDisplay = new HeatIndexDisplay(weatherData)

    weatherData.setMeasurements(80, 65, 30.4f)
    weatherData.setMeasurements(82, 70, 29.2f)
    weatherData.setMeasurements(78, 90, 29.2f)
  }
}
