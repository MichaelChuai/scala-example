package my.testingscala

import org.scalatest.{Tag, GivenWhenThen, Matchers, FunSpec}

/**
  * Created by michael on 3/4/16.
  */
class AlbumSpec extends FunSpec with Matchers with GivenWhenThen {
  describe("An Album") {
    it("can add an Artist to the album at construction time", Tag("construction")) {
      Given("The album Thriller by Michael Jackson")
      val album = new Album("Thriller", 1981, new Artist("Michael", "Jackson"))

      When("the album\'s artist is obtained")
      val artist = album.artist

      Then("the artist obtained should be an instance of Artist")
      artist.isInstanceOf[Artist] should be (true)

      And("the artist\'s first name and last name should be Michael Jackson")
      artist.firstName should be ("Michael")
      artist.lastName should be ("Jackson")
    }
    it("sth to pend") {pending}
    it("haha") {
      1 + 1 should be (2)
    }
  }
}
