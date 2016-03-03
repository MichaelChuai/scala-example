package observer

/**
  * Created by michael on 2/23/16.
  */
class HeatIndexDisplay(weatherData: WeatherData) extends Observer with DisplayElement {
  private var heatIndex: Double = 0.0f

  weatherData.registerObserver(this)

  def computeHeatIndex(t: Double, rh: Double): Double = {
    val index = ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
      + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
      + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
      (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
      (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
      (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
      0.000000000843296 * (t * t * rh * rh * rh)) -
      (0.0000000000481975 * (t * t * t * rh * rh * rh)))
    index
  }

  override def update(t: Double, rh: Double, pressure: Double): Unit =  {
    heatIndex = computeHeatIndex(t, rh)
    display()
  }

  override def display(): Unit = {
    println(f"Heat index is $heatIndex%.2f")
  }

}
