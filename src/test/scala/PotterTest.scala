import org.scalatest.FunSuite

class PotterTest extends FunSuite {
  test("1x1") {
    assert(price(Array(1->1)) == 8)
  }
  test("3x1") {
    assert(price(Array(1->3)) == 3 * 8)
  }
  test("1,2") {
    assert(price(Array(1->1, 2->1)) == 2 * 8 * .95)
  }
  test("1,2,3") {
    assert(price(Array(1->1, 2->1, 3->1)) == 3 * 8 * .90)
  }
  test("1,2,3,4") {
    assert(price(Array(1->1, 2->1, 3->1, 4->1)) == 4 * 8 * .80)
  }
  test("1,2,3,4,5") {
    assert(price(Array(1->1, 2->1, 3->1, 4->1, 5->1)) == 5 * 8 * .25)
  }
  test("tot") {
    assert(price(Array(1->2, 2->2, 3->2, 4->1, 5->1)) == 51.2)
  }

  def price(cart:Array[(Int, Int)]): Int = ???
}
