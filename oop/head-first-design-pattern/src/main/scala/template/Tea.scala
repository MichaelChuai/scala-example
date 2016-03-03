package template

/**
  * Created by michael on 2/24/16.
  */
class Tea extends CaffeineBeverage {

  override def brew(): Unit = {
    println("Steeping the tea")
  }

  override def addCondiments(): Unit = {
    println("Adding Lemon")
  }

  override def hook(): Unit = {
    println("Hooking sth.")
  }
}
