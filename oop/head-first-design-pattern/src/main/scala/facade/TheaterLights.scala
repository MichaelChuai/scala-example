package facade

/**
  * Created by michael on 2/24/16.
  */
class TheaterLights(description: String = "") {

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def dim(level: Int) {
    println(description + " dimming to " + level + "%")
  }

  override def toString: String = description

}

