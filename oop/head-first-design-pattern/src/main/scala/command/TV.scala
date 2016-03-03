package command

/**
  * Created by michael on 2/23/16.
  */
class TV(location: String = "") {
  private var channel: Int = 0

  def on(): Unit = {
    println(location + " TV is on")
  }

  def off(): Unit = {
    println(location + " TV is off")
  }

  def setInputChannel(): Unit = {
    this.channel = 3
    println(location + " TV channel is set for DVD")
  }
}

