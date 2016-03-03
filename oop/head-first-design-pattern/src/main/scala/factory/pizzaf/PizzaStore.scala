package factory.pizzaf

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
    var pizza: Pizza = null
    pz match {
      case "cheese" =>
        pizza = new CheesePizza(NYPizzaIngredientFacory)
        pizza.setName("New York Style Cheese Pizza")
      case "clam" =>
        pizza = new ClamPizza(NYPizzaIngredientFacory)
        pizza.setName("New York Style Clam Pizza")
    }
    pizza
  }
}

object ChicagoPizzaStore extends PizzaStore {
  override def createPizza(pz: String): Pizza = {
    var pizza: Pizza = null
    pz match {
      case "cheese" =>
        pizza = new CheesePizza(ChicagoPizzaIngredientFacory)
        pizza.setName("Chicago Style Cheese Pizza")
      case "clam" =>
        pizza = new ClamPizza(ChicagoPizzaIngredientFacory)
        pizza.setName("Chicago Style Clam Pizza")
    }
    pizza
  }
}
