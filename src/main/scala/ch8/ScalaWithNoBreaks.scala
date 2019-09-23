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

  @tailrec // valideaza la compilare ca scalac poate face optimizare de tail recursion:
  // adica nu ajunge sa-ti cheme functia recursiv, ci o transforma in
  // FOR sau GOTO :)
  def m(n:Int, curr:List[Int] = Nil): List[Int] = {
    if (n == 0) curr else m(n-1, n::curr)
  }

  println(m(0))
  println(m(1))
  println(m(2))
  println(m(3))
//  println(m(10000000))

  metodaDeBiz(c=9)
  def metodaDeBiz(a:Int=1 , b:Int= 2, c:Int): Unit ={
    println(s"$a, $b, $c")
  }

  println(m(Array("-d", "blabla", "-x.scala", "asdakdas.scala")))
}
