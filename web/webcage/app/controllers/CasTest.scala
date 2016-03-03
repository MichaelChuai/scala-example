package controllers

import play.api._
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration.Inf

import models.{Person, Persons}

class CasTest extends Controller {

  def index(id: Int) = Action {
    val p = Await.result(Persons.getById(id), Inf).getOrElse(Person(0, ""))
    Ok(views.html.castest.index(s"id: ${p.id}; name: ${p.name}"))
  }

}
