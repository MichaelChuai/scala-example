package factory.pizzaf

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/23/16.
  */


abstract class Pizza {
  protected var name: String = ""
  protected var dough: Dough = null
  protected var sauce: Sauce = null
  protected var veggies: ArrayBuffer[Veggies] = null
  protected var cheese: Cheese = null
  protected var pepperoni: Pepperoni = null
  protected var clam: Clams = null

  def prepare(): Unit

  def bake(): Unit = {
    println("Bake for 25 minutes at 350")
  }

  def cut(): Unit = {
    println("Cutting the pizza into diagonal slices")
  }

  def box(): Unit = {
    println("Place pizza in official PizaaStore box")
  }

  def setName(name: String): Unit = {
    this.name = name
  }

  def getName(): String = name
}

class CheesePizza(ingredientFactory: PizzaIngredientFactory) extends Pizza {
  override def prepare(): Unit = {
    println(s"Preparing name")
    dough = ingredientFactory.createDough()
    sauce = ingredientFactory.createSauce()
    cheese = ingredientFactory.createCheese()
  }
}

class ClamPizza(ingredientFactory: PizzaIngredientFactory) extends Pizza {
  override def prepare(): Unit = {
    println(s"Preparing name")
    dough = ingredientFactory.createDough()
    sauce = ingredientFactory.createSauce()
    cheese = ingredientFactory.createCheese()
    clam = ingredientFactory.createClam()
  }
}