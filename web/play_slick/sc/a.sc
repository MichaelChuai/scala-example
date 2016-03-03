import slick.driver.PostgresDriver.api._
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import models._
import tables._

object foo {
  val db = Database.forConfig("pt1")
  val persons = TableQuery[Persons]
  def input() = {
    val setup = DBIO.seq(
      persons.schema.create,
      persons ++= Seq(
        Person(None, "Mike"),
        Person(None, "Ann")
      )
    )
    val setupFuture = db.run(setup)
  }

  def sel() = {
    val k = for (p <- persons) yield (p.name)
    db.stream(k.result)//.foreach(println)
  }
}
