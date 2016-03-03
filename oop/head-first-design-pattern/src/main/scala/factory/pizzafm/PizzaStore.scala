package factory.pizzafm

/**
  * Created by michael on 2/23/16.
  */
trait PizzaStore {
  protected def createPizza(pz: String): Pizza

  def orderPizza(pz: String): Pizza = {
    val pizza: Pizza = createPizza(pz)
    pizza.prepare()
    pizza.bake()
    pizza.cut()
    pizza.box()
    pizza
  }
}

object NYPizzaStore extends PizzaStore {
  override def createPizza(pz: String): Pizza = {
    pz match {
      case "cheese" =>
        new NYStyleCheesePizza
      case "clam" =>
        new NYStyleClamPizza
      case "pepperoni" =>
        new NYStylePepperoniPizza
      case "veggie" =>
        new NYStyleVeggiePizza
      case _ => null
    }
  }
}

object ChicagoPizzaStore extends PizzaStore {
  override def createPizza(pz: String): Pizza = {
    pz match {
      case "cheese" =>
        new ChicagoStyleCheesePizza
      case "clam" =>
        new ChicagoStyleClamPizza
      case "pepperoni" =>
        new ChicagoStylePepperoniPizza
      case "veggie" =>
        new ChicagoStyleVeggiePizza
      case _ => null
    }
  }
}
