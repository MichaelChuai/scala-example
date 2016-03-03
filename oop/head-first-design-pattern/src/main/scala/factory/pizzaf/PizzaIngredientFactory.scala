package factory.pizzaf

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/23/16.
  */
trait PizzaIngredientFactory {
  def createDough(): Dough
  def createSauce(): Sauce
  def createCheese(): Cheese
  def createVeggies(): ArrayBuffer[Veggies]
  def createPepperoni(): Pepperoni
  def createClam(): Clams
}

object NYPizzaIngredientFacory extends PizzaIngredientFactory {
  override def createDough(): Dough = new ThinCrustDough
  override def createSauce(): Sauce = new MarinaraSauce
  override def createCheese(): Cheese = new ReggianoCheese
  override def createVeggies(): ArrayBuffer[Veggies] = ArrayBuffer(new Garlic, new Onion, new Mushroom, new RedPepper)
  override def createPepperoni(): Pepperoni = new SlicedPepperoni
  override def createClam(): Clams = new FreshClams
}

object ChicagoPizzaIngredientFacory extends PizzaIngredientFactory {
  override def createDough(): Dough = new ThickCrustDough
  override def createSauce(): Sauce = new PlumTomatoSauce
  override def createCheese(): Cheese = new MozzarellaChees
  override def createVeggies(): ArrayBuffer[Veggies] = ArrayBuffer(new BlackOlives, new Spinach, new EggPlant)
  override def createPepperoni(): Pepperoni = new SlicedPepperoni
  override def createClam(): Clams = new FrozenClams
}
