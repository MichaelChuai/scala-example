package factory.pizzafm

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/23/16.
  */


abstract class Pizza {
  var name: String = ""
  var dough: String = ""
  var sauce: String = ""
  val toppings: ArrayBuffer[String] = ArrayBuffer.empty[String]

  def prepare(): Unit = {
    println(s"Preparing $name")
    println("Tossing dough...")
    println("Adding sauce...")
    println("Adding toppings: ")
    toppings foreach (i => println(s"   ${i}"))
  }

  def bake(): Unit = {
    println("Bake for 25 minutes at 350")
  }

  def cut(): Unit = {
    println("Cutting the pizza into diagonal slices")
  }

  def box(): Unit = {
    println("Place pizza in official PizaaStore box")
  }

  def getName(): String = name
}
