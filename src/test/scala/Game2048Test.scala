import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class Game2048Test extends FunSuite with BeforeAndAfter {

  before {
    println("Setting up fixture")
  }

  test("0 0 0 0") {
    assert(compact(List(0, 0, 0, 0)) == List(0, 0, 0, 0))
  }
  test("0 2 0 0") {
    assert(compact(List(0, 2, 0, 0)) == List(2, 0, 0, 0))
  }
  test("0 0 2 0") {
    assert(compact(List(0, 0, 2, 0)) == List(2, 0, 0, 0))
  }
  test("2 0 2 0") {
    assert(compact(List(2, 0, 2, 0)) == List(4, 0, 0, 0))
  }
  test("4 4 0 0") {
    assert(compact(List(4,4, 0, 0)) == List(8, 0, 0, 0))
  }
  test("2 2 0 0") {
    assert(compact(List(2, 2, 0, 0)) == List(4, 0, 0, 0))
  }
  test("2 2 2 2") {
      assert(compact(List(2,2,2,2)) == List(4,4,0,0))
  }
  test("0 0 0 4") {
      assert(compact(List(0,0,0,4)) == List(4,0,0,0))
  }

  def compact(list: List[Int]): List[Int] = {
    shiftLeft(list) match {
      case 0 :: rest => compact(rest) :+ 0
      case x :: y :: rest if x==y => (x+y :: compact(rest)) :+ 0
      case x :: rest => x :: compact(rest)
      case Nil => Nil
    }
  }
  def shiftLeft(list:List[Int]): List[Int] = list match {
    case 0 :: rest => shiftLeft(rest) :+ 0
    case x :: rest => x :: shiftLeft(rest)
    case Nil => Nil
  }

}
