package command

import scala.collection.mutable.ArrayBuffer

/**
  * Created by michael on 2/23/16.
  */
trait Command {
  def execute(): Unit
  def undo(): Unit
}

object NoCommand extends Command {
  override def execute(): Unit = { }
  override def undo(): Unit = { }
}

class LightOnCommand(light: Light) extends Command {
  override def execute(): Unit = {
    light.on()
  }
  override def undo(): Unit = {
    light.off()
  }
}
class LightOffCommand(light: Light) extends Command {
  override def execute(): Unit = {
    light.off()
  }
  override def undo(): Unit = {
    light.on()
  }
}

class CeilingFanHighCommand(ceilingFan: CeilingFan) extends Command {
  private var prevSpeed: Int = 0
  override def execute(): Unit = {
    prevSpeed = ceilingFan.getSpeed
    ceilingFan.high()
  }
  override def undo(): Unit = {
    prevSpeed match {
      case CeilingFan.HIGH =>
        ceilingFan.high()
      case CeilingFan.MEDIUM =>
        ceilingFan.medium()
      case CeilingFan.LOW =>
        ceilingFan.low()
      case CeilingFan.OFF =>
        ceilingFan.off()
    }
  }
}
class CeilingFanMediumCommand(ceilingFan: CeilingFan) extends Command {
  private var prevSpeed: Int = 0
  override def execute(): Unit = {
    prevSpeed = ceilingFan.getSpeed
    ceilingFan.medium()
  }
  override def undo(): Unit = {
    prevSpeed match {
      case CeilingFan.HIGH =>
        ceilingFan.high()
      case CeilingFan.MEDIUM =>
        ceilingFan.medium()
      case CeilingFan.LOW =>
        ceilingFan.low()
      case CeilingFan.OFF =>
        ceilingFan.off()
    }
  }
}
class CeilingFanLowCommand(ceilingFan: CeilingFan) extends Command {
  private var prevSpeed: Int = 0
  override def execute(): Unit = {
    prevSpeed = ceilingFan.getSpeed
    ceilingFan.low()
  }
  override def undo(): Unit = {
    prevSpeed match {
      case CeilingFan.HIGH =>
        ceilingFan.high()
      case CeilingFan.MEDIUM =>
        ceilingFan.medium()
      case CeilingFan.LOW =>
        ceilingFan.low()
      case CeilingFan.OFF =>
        ceilingFan.off()
    }
  }
}
class CeilingFanOffCommand(ceilingFan: CeilingFan) extends Command {
  private var prevSpeed: Int = 0
  override def execute(): Unit = {
    prevSpeed = ceilingFan.getSpeed
    ceilingFan.off()
  }
  override def undo(): Unit = {
    prevSpeed match {
      case CeilingFan.HIGH =>
        ceilingFan.high()
      case CeilingFan.MEDIUM =>
        ceilingFan.medium()
      case CeilingFan.LOW =>
        ceilingFan.low()
      case CeilingFan.OFF =>
        ceilingFan.off()
    }
  }
}

class GarageDoorUpCommand(garageDoor: GarageDoor) extends Command {
  override def execute(): Unit = {
    garageDoor.up()
  }
  override def undo(): Unit = {
    garageDoor.down()
  }
}
class GarageDoorDownCommand(garageDoor: GarageDoor) extends Command {
  override def execute(): Unit = {
    garageDoor.down()
  }
  override def undo(): Unit = {
    garageDoor.up()
  }
}

class StereoOnWithCDCommand(stereo: Stereo) extends Command {
  override def execute(): Unit = {
    stereo.on()
    stereo.setCD()
    stereo.setVolume(11)
  }
  override def undo(): Unit = {
    stereo.off()
  }
}
class StereoOffCommand(stereo: Stereo) extends Command {
  override def execute(): Unit = {
    stereo.off()
  }
  override def undo(): Unit = {
    stereo.on()
    stereo.setCD()
    stereo.setVolume(11)
  }
}

class TVOnCommand(tv: TV) extends Command {
  override def execute(): Unit = {
    tv.on()
  }
  override def undo(): Unit = {
    tv.off()
  }
}
class TVOffCommand(tv: TV) extends Command {
  override def execute(): Unit = {
    tv.off()
  }
  override def undo(): Unit = {
    tv.on()
  }
}

class HottubOnCommand(hottub: Hottub) extends Command {
  override def execute(): Unit = {
    hottub.on()
    hottub.setTemperature(104)
    hottub.circulate()
  }
  override def undo(): Unit = {
    hottub.setTemperature(98)
    hottub.off()
  }
}
class HottubOffCommand(hottub: Hottub) extends Command {
  override def execute(): Unit = {
    hottub.setTemperature(98)
    hottub.off()
}
  override def undo(): Unit = {
    hottub.on()
    hottub.setTemperature(104)
    hottub.circulate()
  }
}

class MacroCommand(commands: ArrayBuffer[Command]) extends Command {
  override def execute(): Unit = {
    commands foreach (_.execute())
  }
  override def undo(): Unit = {
    commands foreach (_.undo())
  }
}


