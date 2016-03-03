package command

/**
  * Created by michael on 2/23/16.
  */
object RemoteControlTest {
  def main1(args: Array[String]) = {
    val remote = new SimpleRemoteControl
    val light = new Light
    val garageDoor = new GarageDoor
    val lightOn = new LightOnCommand(light)
    val garageOpen = new GarageDoorUpCommand(garageDoor)

    remote.setCommand(lightOn)
    remote.buttonWasPressed()
    remote.setCommand(garageOpen)
    remote.buttonWasPressed()
  }
}
