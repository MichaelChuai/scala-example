package compound

/**
  * Created by michael on 2/24/16.
  */
object DuckSimulator {
  def main1(args: Array[String]) = {
    simulate(CountingDuckFactory)
  }

  def simulate(duckFactory: AbstractDuckFactory):Unit = {
    val redheadDuck = duckFactory.createRedheadDuck()
    val duckCall = duckFactory.createDuckCall()
    val rubberDuck = duckFactory.createRubberDuck()
    val gooseDuck = new GooseAdapter(new Goose)
    //println("\nDuck Simulator: With Composite - Flocks")

    val flockOfDucks = new Flock
    flockOfDucks.add(redheadDuck)
    flockOfDucks.add(duckCall)
    flockOfDucks.add(rubberDuck)
    flockOfDucks.add(gooseDuck)

    val mallard1 = duckFactory.createMallardDuck()
    val mallard2 = duckFactory.createMallardDuck()
    val mallard3 = duckFactory.createMallardDuck()
    val mallard4 = duckFactory.createMallardDuck()
    val flockOfMallards = new Flock
    flockOfMallards.add(mallard1)
    flockOfMallards.add(mallard2)
    flockOfMallards.add(mallard3)
    flockOfMallards.add(mallard4)

    flockOfDucks.add(flockOfMallards)

    println("\nDuck Simulator: With Observer")
    val quackologist = new Quackologist
    flockOfDucks.registerObserver(quackologist)
    simulate(flockOfDucks)


    println(s"The ducks quacked ${QuackCounter.getQuacks} times")
  }

  def simulate(duck: Quackable): Unit = {
    duck.quack()
  }
}
