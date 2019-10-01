package ch26

import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object PartialFunctions extends App {


//  def trateazaSucces(intTry : Try[Int]) = {
//    intTry match {
//      case Success(i) => println(i)
//    }
//  }

//  val trateazaSucces: Try[Int] => Unit =
//  val trateazaSucces: Function1[Try[Int], Unit] = { // Function<IN,OUT>
//  val trateazaSucces: Try[Int] => Unit = {
  val trateazaSucces: PartialFunction[Try[Int], Unit] = {
//  (x:Try[Int])=> x match {
    case Success(i) => println(i)
//  }
  }

  println(" is defined " +
    trateazaSucces.isDefinedAt(Failure(new IllegalArgumentException)))
  println(" is defined " +
    trateazaSucces.isDefinedAt(Success(1)))

//  def trateazaSucces(intTry : Try[Int]) =
//      case Success(i) => println(i)
//implicit val int = 10

  def f(x:Int)(y:Int)(z:Int) = x + y + z
  def g: Int => Int => Int = f(1)
//  def g: Function1[Int, Int => Int] = f(1)
//  def g: Function1[Int, Function1[Int, Int]] = f(1)

  def h = g(2)

  println(g(3))


  trateazaSucces(Success(1))
//  trateazaSucces(Failure(new IllegalArgumentException))

  val i: Int = 1
  val v:Try[Int] = Try(1)

  val ii: Any = i
  val vv: Try[AnyVal] = v
  val vvv: Try[Any] = vv

  private val Doishpe: Regex = """\d{12}(\d{4})""".r

  println(Doishpe matches "1234567890123456")
  println(Doishpe matches "1234567890123")

  val tuple: (Int, Int) = 1 -> 10
  val (a,b) = tuple

  val Doishpe(suffix) = "1234567890123456"
  println(suffix)

  def extrageSuffixCard: String => String = {
    case CardNumber(suf:String) => "*" * 12 + suf
  }
  proceseaza(List("a"),{case CardNumber(suf) => "*" *12 + suf})

  def proceseaza(cards: List[String], extractor: String=>String): Unit = {
//    bla
  }
}

object CardNumber {
  private val Doishpe: Regex = """\d{12}(\d{4})""".r
  def unapply(arg: String): Option[String] = {
    arg match {
      case Doishpe(s) => Some(s)
      case _ => None
    }
  }
}

