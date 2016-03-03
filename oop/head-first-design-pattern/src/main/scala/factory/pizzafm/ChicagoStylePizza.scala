package factory.pizzafm

/**
  * Created by michael on 2/23/16.
  */
class ChicagoStyleCheesePizza extends Pizza {
  name = "Chicago Style Deep Dish Cheese Pizza"
  dough = "Extra Thick Crust Dough"
  sauce = "Plum Tomato Sauce"

  toppings.append("Shredded Mozzarella Cheese")

  override def cut(): Unit = {
    println("Cutting the pizza into square slices")
  }
}

class ChicagoStyleClamPizza extends Pizza {
  name = "Chicago Style Clam Pizza"
  dough = "Extra Thick Crust Dough"
  sauce = "Plum Tomato Sauce"

  toppings.append("Shredded Mozzarella Cheese")
  toppings.append("Frozen Clams from Chesapeake Bay")

  override def cut(): Unit = {
    println("Cutting the pizza into square slices")
  }
}

class ChicagoStylePepperoniPizza extends Pizza {
  name = "Chicago Style Pepperoni Pizza"
  dough = "Extra Thick Crust Dough"
  sauce = "Plum Tomato Sauce"

  toppings.append("Shredded Mozzarella Cheese")
  toppings.append("Black Olives")
  toppings.append("Spinach")
  toppings.append("Eggplant")
  toppings.append("Sliced Pepperoni")

  override def cut(): Unit = {
    println("Cutting the pizza into square slices")
  }
}

class ChicagoStyleVeggiePizza extends Pizza {
  name = "Chicago Deep Dish Veggie Pizza"
  dough = "Extra Thick Crust Dough"
  sauce = "Plum Tomato Sauce"

  toppings.append("Shredded Mozzarella Cheese")
  toppings.append("Black Olives")
  toppings.append("Spinach")
  toppings.append("Eggplant")

  override def cut(): Unit = {
    println("Cutting the pizza into square slices")
  }
}
