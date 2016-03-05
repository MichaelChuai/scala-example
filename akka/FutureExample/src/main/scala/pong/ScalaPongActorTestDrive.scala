package pong

import akka.actor.{ActorRef, ActorSystem}
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._
import akka.pattern.ask

/**
  * Created by michael on 3/4/16.
  */

object ScalaPongActorTestDrive {
  import scala.concurrent.ExecutionContext.Implicits.global
  val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)
  def askPong(message: String, pongActor: ActorRef): Future[String] = (pongActor ? message).mapTo[String]

  def dealSuccess(actor: ActorRef) = {

    val future = askPong("Ping", actor) map (x => x.charAt(0))

    future onSuccess {
      case x: Char => println(s"$x")
    }
    Thread.sleep(100)

    val f2 = askPong("Ping", actor) flatMap (x => askPong("Ping", actor))
    f2 onSuccess {
      case x: String => println(s"Flat $x")
    }
  }

  def dealFailure(actor: ActorRef) = {
    askPong("causeError", actor) onFailure {
      case e: Exception => println("Got exception")
    }

    askPong("causeError", actor) recover {
      case t: Exception => "default"
    } onSuccess {
      case x: String => println(s"$x")
    }

    askPong("causeError", actor) recoverWith {
      case t: Exception => askPong("Ping", actor)
    } onSuccess {
      case x: String => println(s"$x")
    }
  }

  def dealComposing(actor: ActorRef) = {
    val f = askPong("Ping", actor).
      flatMap(x => askPong(s"Ping$x", actor)).
      recover{
        case t: Exception => "There was an error"
      } onSuccess {
      case x => println(x)
    }
  }

  def dealListFutures(actor: ActorRef) = {
    val lstf: List[Future[String]] = List("Ping", "Ping", "failed", "Ping", "haha").
      map(x => askPong(x, actor)).
      map(f => f.recover{case e: Exception => "Failed"})
    val flst = Future.sequence(lstf)
    flst onSuccess {
      case lst: List[String] => lst foreach (println(_))
    }
  }

  def main(args: Array[String]) = {
    val actor: ActorRef = system.actorOf(ScalaPongActor props "PongFoo")
    //dealSuccess(actor)
    //dealFailure(actor)
    //dealComposing(actor)
    dealListFutures(actor)
  }

}
