package facade

/**
  * Created by michael on 2/24/16.
  */
object HomeTheaterTestDrive {
  def main1(args: Array[String]) = {
    val amp: Amplifier = new Amplifier("Top-O-Line Amplifier")
    val tuner: Tuner = new Tuner("Top-O-Line AM/FM Tuner", amp)
    val dvd: DvdPlayer = new DvdPlayer("Top-O-Line DVD Player", amp)
    val cd: CdPlayer = new CdPlayer("Top-O-Line CD Player", amp)
    val projector: Projector = new Projector("Top-O-Line Projector", dvd)
    val lights: TheaterLights = new TheaterLights("Theater Ceiling Lights")
    val screen: Screen = new Screen("Theater Screen")
    val popper: PopcornPopper = new PopcornPopper("Popcorn Popper")

    val homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper)
    homeTheater.watchMovie("Raiders of the Lost Ark")
    homeTheater.endMovie()
  }
}
