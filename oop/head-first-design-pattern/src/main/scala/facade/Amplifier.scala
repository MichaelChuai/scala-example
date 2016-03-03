package facade

/**
  * Created by michael on 2/24/16.
  */
class Amplifier(description: String = "") {
  private var tuner: Tuner = null
  private var dvd: DvdPlayer = null
  private var cd: CdPlayer = null

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def setStereoSound() = {
    println(description + " stereo mode on")
  }

  def setSurroundSound() = {
    println(description + " surround sound on (5 speakers, 1 subwoofer)")
  }

  def setVolume(level: Int) {
    println(description + " setting volume to " + level)
  }

  def setTuner(tuner: Tuner) {
    println(description + " setting tuner to " + dvd)
    this.tuner = tuner
  }

  def setDvd(dvd: DvdPlayer) {
    println(description + " setting DVD player to " + dvd)
    this.dvd = dvd
  }

  def setCd(cd: CdPlayer) {
    println(description + " setting CD player to " + cd)
    this.cd = cd
  }

  override def toString: String = description
}

