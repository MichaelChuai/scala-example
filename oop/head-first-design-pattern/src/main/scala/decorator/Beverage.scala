package decorator

/**
  * Created by michael on 2/23/16.
  */
abstract class Beverage {
  protected var description: String = "Unknown Beverage"

  def getDescription(): String = description
  def cost(): Double
}
