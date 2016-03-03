package adapter

/**
  * Created by michael on 2/24/16.
  */
object DuckTestDrive {
  def main1(args: Array[String]) = {
    val duck = new MallardDuck
    val duckAdapter = new DuckAdapter(duck)
    val turkey = new WildTurkey
    val turkeyAdapter = new TurkeyAdapter(turkey)

    println("The Turkey says...")
    testTurkey(turkey)

    println("The DuckAdapter says...")
    testTurkey(duckAdapter)

    println("The Duck says...")
    testDuck(duck)

    println("The TurkeyAdapter says...")
    testDuck(turkeyAdapter)

  }

  def testDuck(duck: Duck): Unit = {
    duck.quack()
    duck.fly()
  }

  def testTurkey(turkey: Turkey): Unit = {
    turkey.gobble()
    turkey.fly()
  }
}
