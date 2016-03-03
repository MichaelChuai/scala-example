package controllers

import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.Action

import models._
import slick.driver.JdbcProfile
import tables._
import slick.driver.PostgresDriver.api._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

class Application extends Controller {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile]("pt1")(Play.current)
  val ps = TableQuery[Persons]

  def index = Action {
    Ok(views.html.index("Hello world."))
  }

  val personForm: Form[Person] = Form {
    mapping(
      "name" -> text
    )((name: String) => Person(None, name))((p: Person) => Some(p.name))
  }

  def addPerson = Action.async { implicit request =>
    val person: Person = personForm.bindFromRequest.get
    val setup = DBIO.seq(
      ps += person
    )
    dbConfig.db.run(setup).map(_ => Redirect(routes.Application.index()))
  }

  def getPersons = Action { implicit request =>
    val qul = for (p <- ps) yield p.name
    val persons: Seq[String] = Await.result(dbConfig.db.run(qul.result), Duration.Inf)
    val p = persons map ((s: String) => Map("name" -> s))
    Ok(Json.toJson(p))
  }
}
