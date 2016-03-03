package command

/**
  * Created by michael on 2/23/16.
  */
class GarageDoor(location: String = "") {

  def up(): Unit = {
    println(location + " garage Door is Up")
  }

  def down(): Unit = {
    println(location + " garage Door is Down")
  }

  def stop(): Unit = {
    println(location + " garage Door is Stopped")
  }

  def lightOn(): Unit = {
    println(location + " garage light is on")
  }

  def lightOff(): Unit = {
    println(location + " garage light is off")
  }
}

