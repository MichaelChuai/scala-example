package factory

/**
  * Created by michael on 2/23/16.
  */

import factory.pizzaf._
object PizzaTestDrive {
  def main1(args: Array[String]) = {

    var pizza: Pizza = NYPizzaStore.orderPizza("clam")
    println(s"Ethan ordered a ${pizza.getName()}\n")

    pizza = ChicagoPizzaStore.orderPizza("cheese")
    println(s"Joel ordered a ${pizza.getName()}\n")
  }
}


