package adapter

/**
  * Created by michael on 2/24/16.
  */
class TurkeyAdapter(turkey: Turkey) extends Duck{
  override def quack(): Unit = {
    turkey.gobble()
  }
  override def fly(): Unit = {
    for (i <- 1 to 5) {
      turkey.fly()
    }
  }
}
