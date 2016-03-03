package command

/**
  * Created by michael on 2/23/16.
  */
class Stereo(location: String = "") {
  
  def on(): Unit = {
    println(location + " stereo is on")
  }

  def off(): Unit = {
    println(location + " stereo is off")
  }

  def setCD(): Unit = {
    println(location + " stereo is set for CD input")
  }

  def setDVD(): Unit = {
    println(location + " stereo is set for DVD input")
  }

  def setRadio(): Unit = {
    println(location + " stereo is set for Radio")
  }

  def setVolume(volume: Int): Unit = {
    println(location + " Stereo volume set to " + volume)
  }
}

