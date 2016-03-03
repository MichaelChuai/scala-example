package command

/**
  * Created by michael on 2/23/16.
  */


class CeilingFan(location: String = "") {
  private var speed: Int = 0

  def high(): Unit = {
    speed = CeilingFan.HIGH
    println(location + " ceiling fan is on high")
  }

  def medium(): Unit = {
    speed = CeilingFan.MEDIUM
    println(location + " ceiling fan is on medium")
  }

  def low(): Unit = {
    speed = CeilingFan.LOW
    println(location + " ceiling fan is on low")
  }

  def off(): Unit = {
    speed = CeilingFan.OFF
    println(location + " ceiling fan is off")
  }

  def getSpeed: Int = speed
}

object CeilingFan {
  val HIGH: Int = 3
  val MEDIUM: Int = 2
  val LOW: Int = 1
  val OFF: Int = 0
}
