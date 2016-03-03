package facade

/**
  * Created by michael on 2/24/16.
  */
class PopcornPopper(description: String = "") {

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def pop() = {
    println(description + " popping popcorn!")
  }

  override def toString: String = description
}
