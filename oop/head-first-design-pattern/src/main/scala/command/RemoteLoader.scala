package command

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/23/16.
  */
object RemoteLoader {
  def main1(args: Array[String]) = {
    val remoteControl = new RemoteControl

    val livingRoomLight = new Light("Living Room")
    val kitchenLight = new Light("Kitchen")
    val ceilingFan = new CeilingFan("Living Room")
    val garageDoor = new GarageDoor
    val stereo = new Stereo("Living Room")

    val livingRoomLightOn = new LightOnCommand(livingRoomLight)
    val livingRoomLightOff = new LightOffCommand(livingRoomLight)
    val kitchenLightOn = new LightOnCommand(kitchenLight)
    val kitchenLightOff = new LightOffCommand(kitchenLight)

    val ceilingFanHigh = new CeilingFanHighCommand(ceilingFan)
    val ceilingFanOff = new CeilingFanOffCommand(ceilingFan)

    val garageDoorUp = new GarageDoorUpCommand(garageDoor)
    val garageDoorDown = new GarageDoorDownCommand(garageDoor)

    val stereoOnWithCD = new StereoOnWithCDCommand(stereo)
    val stereoOff = new StereoOffCommand(stereo)

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff)
    remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff)
    remoteControl.setCommand(3, stereoOnWithCD, stereoOff)

    println(remoteControl)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(1)
    remoteControl.offButtonWasPushed(1)
    remoteControl.onButtonWasPushed(2)
    remoteControl.offButtonWasPushed(2)
    remoteControl.onButtonWasPushed(3)
    remoteControl.offButtonWasPushed(3)
  }
  def main2(args: Array[String]) = {
    val remoteControl = new RemoteControl
    val livingRoomLight = new Light("Living Room")
    val livingRoomLightOn = new LightOnCommand(livingRoomLight)
    val livingRoomLightOff = new LightOffCommand(livingRoomLight)
    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println(remoteControl)
    remoteControl.undoButtonWasPushed()
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(0)
    println(remoteControl)
    remoteControl.undoButtonWasPushed()
  }

  def main3(args: Array[String]) = {
    val remoteControl = new RemoteControl

    val ceilingFan = new CeilingFan("Living Room")

    val ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan)
    val ceilingFanHigh = new CeilingFanHighCommand(ceilingFan)
    val ceilingFanOff = new CeilingFanOffCommand(ceilingFan)

    remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff)
    remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println(remoteControl)
    remoteControl.undoButtonWasPushed()

    remoteControl.onButtonWasPushed(1)
    println(remoteControl)
    remoteControl.undoButtonWasPushed()
  }

  def main4(args: Array[String]) = {
    val remoteControl = new RemoteControl
    val light = new Light("Living Room")
    val tv = new TV("Living Room")
    val stereo = new Stereo("Living Room")
    val hottub = new Hottub

    val lightOn = new LightOnCommand(light)
    val stereoOn = new StereoOnWithCDCommand(stereo)
    val tvOn = new TVOnCommand(tv)
    val hottubOn = new HottubOnCommand(hottub)

    val lightOff = new LightOffCommand(light)
    val stereoOff = new StereoOffCommand(stereo)
    val tvOff = new TVOffCommand(tv)
    val hottubOff = new HottubOffCommand(hottub)

    val partyOn: ArrayBuffer[Command] = ArrayBuffer(lightOn, stereoOn, tvOn, hottubOn)
    val partyOff: ArrayBuffer[Command] = ArrayBuffer(lightOff, stereoOff, tvOff, hottubOff)

    val partyOnMacro = new MacroCommand(partyOn)
    val partyOffMacro = new MacroCommand(partyOff)

    remoteControl.setCommand(0, partyOnMacro, partyOffMacro)

    println(remoteControl)
    println("--- Pushing Macro On ---")
    remoteControl.onButtonWasPushed(0)
    //println("--- Pushing Macro Off ---")
    //remoteControl.offButtonWasPushed(0)
    println("--- Pushing Macro Undo ---")
    remoteControl.undoButtonWasPushed()
    println(remoteControl)
  }
}
