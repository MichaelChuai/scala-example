package facade

/**
  * Created by michael on 2/24/16.
  */
class Projector(description: String = "", dvdPlayer: DvdPlayer = null) {

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def wideScreenMode() = {
    println(description + " in widescreen mode (16x9 aspect ratio)")
  }

  def tvMode() = {
    println(description + " in tv mode (4x3 aspect ratio)")
  }

  override def toString: String = description
  
}