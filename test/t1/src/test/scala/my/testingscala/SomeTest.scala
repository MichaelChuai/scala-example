package my.testingscala

/**
  * Created by michael on 3/4/16.
  */

import org.scalatest.FunSpec
import org.scalatest.Matchers

class SomeTest extends FunSpec with Matchers {
  describe("General test") {
    it("t1") {
      Abc.foo(1, 2) should be (3)
    }
    it("t2") {
      val a = "abc"
      a should startWith("a")
    }
    it("t3") {
      val a = 42
      a should be < (50)
      a should be > (20)
      a should not be (60)
    }
    it("t4") {
      (0.9 - 0.8) should be (0.1 +- 0.01)
      (0.4 + 0.1) should not be (40.0 +- 0.3)
    }
    it("t5") {
      val bg = new Artist("Garth", "Brooks")
      val cg = bg
      bg should be theSameInstanceAs(cg)
      val dg = new Artist("Debbie", "Harry")
      bg should not be theSameInstanceAs(dg)
    }
    it("t6") {
      List() should have size(0)
      (1 to 10) should contain(7)
    }
    it("t7") {
      val map = Map("jp" -> 1, "am" -> 2)
      map should contain key("jp")
      info("key check passed")
      map should contain value(2)
      info("value check passed")
      map should not contain key("pm")
      map should (contain key("jp") and (not contain key("pm") or contain key("am")))
    }
  }
}
