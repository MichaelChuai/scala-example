package singleton

/**
  * Created by michael on 2/23/16.
  */
object Singleton {
  def main1(args: Array[String]) = {
    ChocolateBoiler.fill()
    ChocolateBoiler.boil()
    ChocolateBoiler.drain()
  }
}
