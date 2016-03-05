package pong

/**
  * Created by michael on 3/5/16.
  */

import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}
import akka.actor.{Props, ActorSystem}

import akka.pattern.ask
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._

class ScalaAskExamplesTest extends FunSpecLike with Matchers {
  val system  = ActorSystem()
  implicit val timeout = Timeout(5 seconds)
  val pongActor = system.actorOf(ScalaPongActor props "Ponging")
  describe("Pong actor") {
    it("should respond with Pong") {
      val future = pongActor ? "Ping"
      val result = Await.result(future.mapTo[String], 1 second)
      result should be("Ponging")
    }

    it("should fail on unknown message") {
      val future = pongActor ? "unknown"
      intercept[Exception] {
        Await.result(future.mapTo[String], 1 second)
      }
    }
  }
  def askPong(message: String): Future[String] = (pongActor ? message).mapTo[String]

  describe("FutureExamples") {
    import scala.concurrent.ExecutionContext.Implicits.global
    it("should print to console") {
      (pongActor ? "Ping").onSuccess{
        case x: String => println(s"replied with: $x")
      }
      Thread.sleep(100)
    }
  }
}
