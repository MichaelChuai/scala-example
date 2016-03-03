package template

/**
  * Created by michael on 2/24/16.
  */
trait CaffeineBeverage {
  final def prepareRecipe(): Unit = {
    boilWater()
    brew()
    pourInCup()
    if (customerWantsCondiments()) {
      addCondiments()
    }
    hook()
  }

  def brew(): Unit
  def addCondiments(): Unit

  def boilWater(): Unit = {
    println("Boiling water")
  }

  def pourInCup(): Unit = {
    println("Pouring into cup")
  }

  def customerWantsCondiments(): Boolean = true

  def hook(): Unit = { }

}
