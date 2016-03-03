package facade

/**
  * Created by michael on 2/24/16.
  */
class Tuner(description: String = "", amplifier: Amplifier = null) {
  private var frequency: Double = .0
  
  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def setFrequency(frequency: Double) {
    println(description + " setting frequency to " + frequency)
    this.frequency = frequency
  }

  def setAm() = {
    println(description + " setting AM mode")
  }

  def setFm() = {
    println(description + " setting FM mode")
  }

  override def toString: String = description

}