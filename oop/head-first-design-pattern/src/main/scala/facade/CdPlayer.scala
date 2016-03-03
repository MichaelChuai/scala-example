package facade

/**
  * Created by michael on 2/24/16.
  */
class CdPlayer(description: String = "", amplifier: Amplifier = null) {
  private var currentTrack: Int = 0
  private var title: String = null

  def on() = {
    println(description + " on")
  }

  def off() = {
    println(description + " off")
  }

  def eject() = {
    title = null
    println(description + " eject")
  }

  def play(title: String) {
    this.title = title
    currentTrack = 0
    println(description + " playing \"" + title + "\"")
  }

  def play(track: Int) {
    if (title == null) {
      println(description + " can't play track " + currentTrack + ", no cd inserted")
    }
    else {
      currentTrack = track
      println(description + " playing track " + currentTrack)
    }
  }

  def stop() = {
    currentTrack = 0
    println(description + " stopped")
  }

  def pause() = {
    println(description + " paused \"" + title + "\"")
  }

  override def toString: String = description
}

