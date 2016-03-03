package command

/**
  * Created by michael on 2/23/16.
  */
class Light(location: String = "") {
  def on():Unit = {
    println(location + " light is on")
  }

  def off(): Unit = {
    println(location + " light is off")
  }
}
