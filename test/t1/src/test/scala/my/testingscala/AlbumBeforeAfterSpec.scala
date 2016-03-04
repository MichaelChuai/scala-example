package my.testingscala

import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}

import scala.collection.mutable.ListBuffer

/**
  * Created by michael on 3/4/16.
  */
class AlbumBeforeAfterSpec extends FunSpec with Matchers with BeforeAndAfter {
  val h = new ListBuffer[Album]()

  before{
    info("Starting to populate the discography")
    h += new Album("Dare", 1981, new Artist("a", "b"))
  }

  describe("A mutable ListBuffer of albums") {
    it("have a size of 3 when two more albums are added to the Human League Discography") {
      h += new Album("Dare", 1981, new Artist("a", "b"))
      h += new Album("Dare", 1981, new Artist("a", "b"))
      h should have size(3)
    }

    it("have a size of 2 when one more album is added to the Human League Discography") {
      h += new Album("Dare", 1981, new Artist("a", "b"))
      h should have size(2)
    }
  }

  after {
    info("Clearing the discography")
    h.clear()
  }
}
