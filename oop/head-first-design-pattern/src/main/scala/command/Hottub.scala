package command

/**
  * Created by michael on 2/23/16.
  */
class Hottub {
  private var isOn: Boolean = false
  private var temperature: Int = 0

  def on(): Unit = {
    isOn = true
  }

  def off(): Unit = {
    isOn = false
  }

  def circulate(): Unit = {
    if (isOn) {
      println("Hottub is bubbling!")
    }
  }

  def jetsOn(): Unit = {
    if (isOn) {
      println("Hottub jets are on")
    }
  }

  def jetsOff(): Unit = {
    if (isOn) {
      println("Hottub jets are off")
    }
  }

  def setTemperature(temperature: Int): Unit = {
    if (temperature > this.temperature) {
      println("Hottub is heating to a steaming " + temperature + " degrees")
    }
    else {
      println("Hottub is cooling to " + temperature + " degrees")
    }
    this.temperature = temperature
  }
}

