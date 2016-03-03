package decorator

/**
  * Created by michael on 2/23/16.
  */
class TallCup(beverage: Beverage) extends CupSizeDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Tall cup"
  }

  override def cost(): Double = {
    0.10 + beverage.cost()
  }
}

class GrandeCup(beverage: Beverage) extends CupSizeDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Grande cup"
  }

  override def cost(): Double = {
    0.15 + beverage.cost()
  }
}

class VentiCup(beverage: Beverage) extends CupSizeDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Venti cup"
  }

  override def cost(): Double = {
    0.20 + beverage.cost()
  }
}
