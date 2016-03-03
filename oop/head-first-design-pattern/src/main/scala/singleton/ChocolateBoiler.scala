package singleton

/**
  * Created by michael on 2/23/16.
  */
object ChocolateBoiler {
  private var empty: Boolean = true
  private var boiled: Boolean = false

  def fill(): Unit = {
    if (isEmpty) {
      empty = false
      boiled = false
    }
    println("Filling...")
  }

  def drain(): Unit = {
    if (!isEmpty && isBoiled) {
      empty = true
    }
    println("Draining...")
  }

  def boil(): Unit = {
    if (!isEmpty && !isBoiled) {
      boiled = true
    }
    println("Boiling...")
  }

  def isEmpty: Boolean = empty
  def isBoiled: Boolean = boiled

}
