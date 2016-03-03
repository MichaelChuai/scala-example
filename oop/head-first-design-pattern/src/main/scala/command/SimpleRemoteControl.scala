package command

/**
  * Created by michael on 2/23/16.
  */
class SimpleRemoteControl {
  private var slot: Command = null

  def setCommand(command: Command): Unit = {
    slot = command
  }

  def buttonWasPressed(): Unit = {
    slot.execute()
  }
}
