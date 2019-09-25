package ch19

import java.util.Collections

class Order {
  val name = "ceva specific order"
}
class PizzaOrder extends Order
class BeerOrder extends Order

class OrderProcessor[T <: Order] {
  def process(t: T): Unit = {
    println(t.name)
//    Collections.sort
  }
}


object BoundsPlay extends App{
  new OrderProcessor[PizzaOrder]
  new OrderProcessor[Order]
//  new OrderProcessor[String]


  val f1: Int => String = null
  val f1bis: Function1[Int, String] = null
  val f2: Function[Int, Any] = f1
  val f3frate: Function[Nothing, Any] = f1

  val g : Seq[Any] => String = _.mkString("")

  val g1 : List[Int] => Any = g // HORROR

  val s1: String = g(Array[String]("A","B"))
  val s2: Any =  g1(List(1))

  println(s"s1:$s1")
  println(s"s2:$s2")
  def aruncate(): Nothing = throw new IllegalArgumentException
}