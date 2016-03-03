package decorator

/**
  * Created by michael on 2/23/16.
  */

class Espresso extends Beverage {
  description = "Espresso"

  override def cost(): Double = 1.99

}

class HouseBlend extends Beverage {
  description = "House Blend Coffee"

  override def cost(): Double = 0.89
}

class DarkRoast extends Beverage {
  description = "Dark Roast Coffee"

  override def cost(): Double = 0.99
}

class Decat extends Beverage {
  description = "Decaf Coffee"

  override def cost(): Double = 1.05
}