package state

/**
  * Created by michael on 2/24/16.
  */
object GumballMachineTestDrive {
  def main1(args: Array[String]) = {
    val gumballMachine = new GumballMachine(5)

    println(gumballMachine)

    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()

    println(gumballMachine)

    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    gumballMachine.insertQuarter()
    gumballMachine.turnCrank()
    println(gumballMachine)

    gumballMachine.refill(5)

    println(gumballMachine)
  }
}
