package compound

/**
  * Created by michael on 2/24/16.
  */

trait AbstractDuckFactory {
  def createMallardDuck(): Quackable
  def createRedheadDuck(): Quackable
  def createDuckCall(): Quackable
  def createRubberDuck(): Quackable
}

object DuckFactory extends AbstractDuckFactory {
  override def createMallardDuck(): Quackable = new MallardDuck
  override def createRedheadDuck(): Quackable = new RedheadDuck
  override def createDuckCall(): Quackable = new DuckCall
  override def createRubberDuck(): Quackable = new RubberDuck
}

object CountingDuckFactory extends AbstractDuckFactory {
  override def createMallardDuck(): Quackable = new QuackCounter(new MallardDuck)
  override def createRedheadDuck(): Quackable = new QuackCounter(new RedheadDuck)
  override def createDuckCall(): Quackable = new QuackCounter(new DuckCall)
  override def createRubberDuck(): Quackable = new QuackCounter(new RubberDuck)
}

