package template

/**
  * Created by michael on 2/24/16.
  */
class Coffee extends CaffeineBeverage {

  override def brew(): Unit = {
    println("Dripping Coffee through filter")
  }

  override def addCondiments(): Unit = {
    println("Adding Sugar and Milk")
  }

  override def customerWantsCondiments(): Boolean = {
    val s = "n"
    s match {
      case "y" => true
      case _ => false
    }
  }

}
