package decorator

/**
  * Created by michael on 2/23/16.
  */
class Mocha(beverage: Beverage) extends CondimentDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Mocha"
  }

  override def cost(): Double = {
    0.20 + beverage.cost()
  }
}

class Soy(beverage: Beverage) extends CondimentDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Soy"
  }

  override def cost(): Double = {
    0.15 + beverage.cost()
  }
}

class Whip(beverage: Beverage) extends CondimentDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Whip"
  }

  override def cost(): Double = {
    0.10 + beverage.cost()
  }
}

class Milk(beverage: Beverage) extends CondimentDecorator {
  override def getDescription(): String = {
    s"${beverage.getDescription()}, Milk"
  }

  override def cost(): Double = {
    0.10 + beverage.cost()
  }
}


