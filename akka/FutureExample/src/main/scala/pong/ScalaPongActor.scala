package pong

import akka.actor.{Props, Status, Actor}

/**
  * Created by michael on 3/4/16.
  */


class ScalaPongActor(response: String) extends Actor {
  override def receive = {
    case "Ping" => sender() ! response
    case _ => sender() ! Status.Failure(new Exception("unknown message"))
  }
}

object ScalaPongActor {
  def props(response: String): Props = {
    Props(classOf[ScalaPongActor], response)
  }
}

