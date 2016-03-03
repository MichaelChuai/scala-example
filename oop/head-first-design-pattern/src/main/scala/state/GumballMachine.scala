package state

/**
  * Created by michael on 2/24/16.
  */
class GumballMachine(numberGumballs: Int) {
  val soldOutState: SoldOutState = new SoldOutState(this)
  val noQuarterState: NoQuarterState = new NoQuarterState(this)
  val hasQuarterState: HasQuarterState = new HasQuarterState(this)
  val soldState: SoldState = new SoldState(this)
  val winnerState: WinnerState = new WinnerState(this)
  private var count: Int = numberGumballs
  private var state: State = soldOutState
  if (numberGumballs > 0) {
    state = noQuarterState
  }

  def insertQuarter(): Unit = {
    state.insertQuarter()
  }

  def ejectQuarter(): Unit = {
    state.ejectQuarter()
  }

  def turnCrank(): Unit = {
    state.turnCrank()
    state.dispense()
  }

  def setState(state: State): Unit = {
    this.state = state
  }

  def releaseBall(): Unit = {
    println("A gumball comes rolling out the slot...")
    if (count != 0) count -= 1
  }

  def getCount: Int = count

  def refill(count: Int): Unit = {
    this.count += count
    println("The gumball machine was just refilled; it's new count is: " + this.count)
    state.refill()
  }

  def getState: State = state
  def getSoldOutState: State = soldOutState
  def getNoQuarterState: State = noQuarterState
  def getHasQuarterState: State = hasQuarterState
  def getSoldState: State = soldState
  def getWinnerState: State = winnerState

  override def toString: String = {
    val result = new StringBuilder
    result.append("\nMighty Gumball, Inc.")
    result.append("\nJava-enabled Standing Gumball Model #2004")
    result.append("\nInventory: " + count + " gumball")
    if (count != 1) {
      result.append("s")
    }
    result.append("\n")
    result.append("Machine is " + state + "\n")
    result.toString
  }
}






