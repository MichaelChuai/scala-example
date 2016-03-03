package facade

/**
  * Created by michael on 2/24/16.
  */
class HomeTheaterFacade(
                       amp: Amplifier,
                       tuner: Tuner,
                       dvd: DvdPlayer,
                       cd: CdPlayer,
                       projector: Projector,
                       screen: Screen,
                       lights: TheaterLights,
                       popper: PopcornPopper
                       ) {
  def watchMovie(movie: String): Unit = {
    println("Get ready to watch a movie...")
    popper.on()
    popper.pop()
    lights.dim(10)
    screen.down()
    projector.on()
    projector.wideScreenMode()
    amp.on()
    amp.setDvd(dvd)
    amp.setSurroundSound()
    amp.setVolume(5)
    dvd.on()
    dvd.play(movie)
  }

  def endMovie(): Unit = {
    println("Shutting movie theater down...")
    popper.off()
    lights.on()
    screen.up()
    projector.off()
    amp.off()
    dvd.stop()
    dvd.eject()
    dvd.off()
  }
}
