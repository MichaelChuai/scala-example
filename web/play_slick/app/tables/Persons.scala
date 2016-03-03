package tables

/**
  * Created by michael on 12/28/15.
  */

import slick.driver.PostgresDriver.api._
import models._

class Persons(tag: Tag) extends Table[Person](tag, "PERSON") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def * = (id.?, name) <> (Person.tupled, Person.unapply)
}
