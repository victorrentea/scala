package ch8

import scala.annotation.tailrec

object ScalaWithNoBreaks extends App{
  def m(arr: Array[String]): Boolean = {

    for (s <- arr) {
      if (!s.startsWith("-") && s.endsWith(".scala"))
        return true
    }
    false
  }

  def m(n:Int): List[Int] = {
    @tailrec
    def rec(n:Int):List[Int] = if (n == 0) Nil else n :: rec(n-1)
    rec(n).reverse
  }

  println(m(0))
  println(m(1))
  println(m(2))
  println(m(3))
  println(m(10000000))


  println(m(Array("-d", "blabla", "-x.scala", "asdakdas.scala")))
}
