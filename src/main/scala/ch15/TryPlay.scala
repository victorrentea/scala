package ch15

import scala.util.{Failure, Success, Try}

object TryPlay extends App {
  def sSquared(s:String): Try[Int] = {
    Try {
      val i = Integer.parseInt(s)
      i * i
    }
  }
    // injURATURA?

  def sSquaredList(sList:Array[String]): Array[Try[Int]] = {
    for (s <- sList) yield sSquared(s)
  }

  println(sSquared("2"))
  val failed = sSquared("2")
  println(failed)
  println(sSquaredList(Array("2","a","3")).mkString(" "))

  println(printRez(failed))
  val ex = failed match {
    case Failure(e) => e
    case _ => null // shaorma
  }
  println("ex pescuita" + ex)

  failed match {
    case Failure(_) => println("POC")
  }

  println(".get " + failed.failed.get)

  def printRez(t:Try[Int]):String = t match {
    case Success(value) => value.toString
    case Failure(exception) => exception.toString
  }
}
