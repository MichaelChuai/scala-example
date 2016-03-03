package factory.pizzafm

/**
  * Created by michael on 2/23/16.
  */
class NYStyleCheesePizza extends Pizza {
  name = "NY Style Sauce and Cheese Pizza"
  dough = "Thin Crust Dough"
  sauce = "Marinara Sauce"

  toppings.append("Grated Reggiano Cheese")
}

class NYStyleClamPizza extends Pizza {
  name = "NY Style Clam Pizza"
  dough = "Thin Crust Dough"
  sauce = "Marinara Sauce"

  toppings.append("Grated Reggiano Cheese")
  toppings.append("Fresh Clams from Long Island Sound")
}

class NYStylePepperoniPizza extends Pizza {
  name = "NY Style Pepperoni Pizza"
  dough = "Thin Crust Dough"
  sauce = "Marinara Sauce"

  toppings.append("Grated Reggiano Cheese")
  toppings.append("Sliced Pepperoni")
  toppings.append("Garlic")
  toppings.append("Onion")
  toppings.append("Mushrooms")
  toppings.append("Red Pepper")
}

class NYStyleVeggiePizza extends Pizza {
  name = "NY Style Veggie Pizza"
  dough = "Thin Crust Dough"
  sauce = "Marinara Sauce"

  toppings.append("Grated Reggiano Cheese")
  toppings.append("Garlic")
  toppings.append("Onion")
  toppings.append("Mushrooms")
  toppings.append("Red Pepper")
}
