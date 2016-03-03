package compound

/**
  * Created by michael on 2/24/16.
  */
class Quackologist extends Observer {
  override def update(duck: QuackObservable): Unit = {
    println(s"Quackologist: $duck just quacked")
  }
}
