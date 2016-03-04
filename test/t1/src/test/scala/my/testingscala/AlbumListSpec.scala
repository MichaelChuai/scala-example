package my.testingscala

import org.scalatest.{OneInstancePerTest, FunSpec, Matchers}

import scala.collection.mutable.ListBuffer

/**
  * Created by michael on 3/4/16.
  */
class AlbumListSpec extends FunSpec with Matchers with OneInstancePerTest {
  val g = new ListBuffer[Album]()
  g += new Album("Portfolio", 1977, new Artist("Grace", "Jones"))

  describe("Given an initial Grace Jones Discography") {
    it("when an additional two albums are added, then the discography size should be 3") {
      g += new Album("Fame", 1978, new Artist("Grace", "Jones"))
      g += new Album("Muse", 1979, new Artist("Grace", "Jones"))
      g should have size(3)
    }

    it("when one additional album is added, then the discography size should be 2") {
      g += new Album("Muse", 1979, new Artist("Grace", "Jones"))
      g should have size(2)
    }
  }
}
