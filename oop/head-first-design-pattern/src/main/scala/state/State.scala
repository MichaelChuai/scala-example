package state

import scala.util.Random

/**
  * Created by michael on 2/24/16.
  */
trait State {
  def insertQuarter(): Unit
  def ejectQuarter(): Unit
  def turnCrank(): Unit
  def dispense(): Unit
  def refill(): Unit
}

class SoldState(gumballMachine: GumballMachine) extends State {
  def insertQuarter() = {
    println("Please wait, we're already giving you a gumball")
  }

  def ejectQuarter() = {
    println("Sorry, you already turned the crank")
  }

  def turnCrank() = {
    println("Turning twice doesn't get you another gumball!")
  }

  def dispense() = {
    gumballMachine.releaseBall()
    if (gumballMachine.getCount > 0) {
      gumballMachine.setState(gumballMachine.getNoQuarterState)
    }
    else {
      println("Oops, out of gumballs!")
      gumballMachine.setState(gumballMachine.getSoldOutState)
    }
  }

  def refill() = {
  }

  override def toString: String = "dispensing a gumball"

}

class SoldOutState(gumballMachine: GumballMachine) extends State {
  def insertQuarter() = {
    println("You can't insert a quarter, the machine is sold out")
  }

  def ejectQuarter() = {
    println("You can't eject, you haven't inserted a quarter yet")
  }

  def turnCrank() = {
    println("You turned, but there are no gumballs")
  }

  def dispense() = {
    println("No gumball dispensed")
  }

  def refill() = {
    gumballMachine.setState(gumballMachine.getNoQuarterState)
  }

  override def toString: String = "sold out"
}

class NoQuarterState(gumballMachine: GumballMachine) extends State {
  def insertQuarter() = {
    println("You inserted a quarter")
    gumballMachine.setState(gumballMachine.getHasQuarterState)
  }

  def ejectQuarter() = {
    println("You haven't inserted a quarter")
  }

  def turnCrank() = {
    println("You turned, but there's no quarter")
  }

  def dispense() = {
    println("You need to pay first")
  }

  def refill() = {
  }

  override def toString: String = "waiting for quarter"
}

class HasQuarterState(gumballMachine: GumballMachine) extends State {
  def insertQuarter() = {
    println("You can't insert another quarter")
  }

  def ejectQuarter() = {
    println("Quarter returned")
    gumballMachine.setState(gumballMachine.getNoQuarterState)
  }

  def turnCrank() = {
    println("You turned...")
    if (Random.nextInt(2) == 0 && gumballMachine.getCount > 1) {
      gumballMachine.setState(gumballMachine.getWinnerState)
    } else {
      gumballMachine.setState(gumballMachine.getSoldState)
    }
  }

  def dispense() = {
    println("No gumball dispensed")
  }

  def refill() = {
  }

  override def toString: String = "waiting for turn of crank"
}

class WinnerState(gumballMachine: GumballMachine) extends State {
  def insertQuarter() = {
    println("Please wait, we're already giving you a gumball")
  }

  def ejectQuarter() = {
    println("Sorry, you already turned the crank")
  }

  def turnCrank() = {
    println("Turning twice doesn't get you another gumball!")
  }

  override def dispense() = {
    println("YOU ARE A WINNER! You get two gumballs for your quarter")
    gumballMachine.releaseBall()
    gumballMachine.releaseBall()
    if (gumballMachine.getCount > 0) {
      gumballMachine.setState(gumballMachine.getNoQuarterState)
    } else {
      println("Oops, out of gumballs!")
      gumballMachine.setState(gumballMachine.getSoldOutState)
    }

  }

  override def refill() = {
  }

  override def toString: String = "despensing two gumballs for your quarter, because YOU'RE A WINNER!"
}




