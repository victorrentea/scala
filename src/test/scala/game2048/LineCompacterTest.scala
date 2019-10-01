package game2048

import game2048.LineCompacter.compactLeft
import org.scalatest.{BeforeAndAfter, FunSuite}

class LinecompactLefterTest extends FunSuite with BeforeAndAfter {

  before {
    println("Setting up fixture")
  }

  test("0 0 0 0") {
    assert(compactLeft(List(0, 0, 0, 0)) == List(0, 0, 0, 0))
  }
  test("0 2 0 0") {
    assert(compactLeft(List(0, 2, 0, 0)) == List(2, 0, 0, 0))
  }
  test("0 0 2 0") {
    assert(compactLeft(List(0, 0, 2, 0)) == List(2, 0, 0, 0))
  }
  test("2 0 2 0") {
    assert(compactLeft(List(2, 0, 2, 0)) == List(4, 0, 0, 0))
  }
  test("4 4 0 0") {
    assert(compactLeft(List(4,4, 0, 0)) == List(8, 0, 0, 0))
  }
  test("2 2 0 0") {
    assert(compactLeft(List(2, 2, 0, 0)) == List(4, 0, 0, 0))
  }
  test("2 2 2 2") {
      assert(compactLeft(List(2,2,2,2)) == List(4,4,0,0))
  }
  test("0 0 0 4") {
      assert(compactLeft(List(0,0,0,4)) == List(4,0,0,0))
  }


}
