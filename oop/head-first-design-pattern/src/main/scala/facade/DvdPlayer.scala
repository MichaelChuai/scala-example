package facade

/**
  * Created by michael on 2/24/16.
  */
class DvdPlayer(description: String = "", amplifier: Amplifier = null) {
  private var currentTrack: Int = 0
  private var movie: String = null

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def eject() = {
    movie = null
    println(description + " eject")
  }

  def play(movie: String) {
    this.movie = movie
    currentTrack = 0
    println(description + " playing \"" + movie + "\"")
  }

  def play(track: Int) {
    if (movie == null) {
      println(description + " can't play track " + track + " no dvd inserted")
    }
    else {
      currentTrack = track
      println(description + " playing track " + currentTrack + " of \"" + movie + "\"")
    }
  }

  def stop() = {
    currentTrack = 0
    println(description + " stopped \"" + movie + "\"")
  }

  def pause() = {
    println(description + " paused \"" + movie + "\"")
  }

  def setTwoChannelAudio() = {
    println(description + " set two channel audio")
  }

  def setSurroundAudio() = {
    println(description + " set surround audio")
  }

  override def toString: String = description
  
}
