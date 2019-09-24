package ch15

import scala.util.Try

object TryPlay extends App {
  def sSquared(s:String): (String,Try[Int]) = {
    s -> Try {
      val i = Integer.parseInt(s)
      i * i
    }
  }

  def sSquaredList(sList:Array[String]): Array[(String,Try[Int])] = {
    for (s <- sList) yield sSquared(s)
  }

  println(sSquared("2"))
  println(sSquaredList(Array("2","a","3")).mkString(" "))

}
