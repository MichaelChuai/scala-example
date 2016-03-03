package command

import scala.collection.mutable.ArrayBuffer


/**
  * Created by michael on 2/23/16.
  */
class RemoteControl {

  private val onCommands: ArrayBuffer[Command] = ArrayBuffer.fill[Command](7)(NoCommand)
  private val offCommands: ArrayBuffer[Command] = ArrayBuffer.fill[Command](7)(NoCommand)
  private var undoCommand: Command = NoCommand

  def setCommand(slot: Int, onCommand: Command, offCommand: Command): Unit = {
    onCommands(slot) = onCommand
    offCommands(slot) = offCommand
  }

  def onButtonWasPushed(slot: Int): Unit = {
    onCommands(slot).execute()
    undoCommand = onCommands(slot)
  }

  def offButtonWasPushed(slot: Int): Unit = {
    offCommands(slot).execute()
    undoCommand = offCommands(slot)
  }

  def undoButtonWasPushed(): Unit = {
    undoCommand.undo()
  }

  override def toString = {
    val stringBuff = new StringBuilder
    stringBuff.append("\n------ Remote Control ------\n")
    for (i <- onCommands.indices) {
      stringBuff.append(s"[slot $i] ${onCommands(i).getClass.getName}\t${offCommands(i).getClass.getName}\n")
      //stringBuff.append(s"[slot $i] ${onCommands(i)}\t${offCommands(i)}\n")
    }
    stringBuff.append(s"[undo] ${undoCommand.getClass.getName}")
    stringBuff.toString
  }
}


