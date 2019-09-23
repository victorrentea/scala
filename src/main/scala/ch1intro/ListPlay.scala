package ch1intro

import scala.collection.mutable

object ListPlay extends App {

  val list = List(1,2,3) // LinkedList dar Uni-Directionala ~= Stack

  println(list(0))
//  list(0)=10 // NU! unei Liste in Scala nu ii poti modifica un element

  //  new mutable.MutableList[] de evitat

  val list2 = list :+ 4 // evitati adaugarea de noi elemente la finalul listei. => scump computational
  println(list2)

  // metodele care se termina cu : sunt asociative la dreapta
  var list3var = 1 +: list //-1 :: 0 :: list
  var list3var2 = -1 :: 0 :: list

  println("Dubla: " + (list ::: list))

  println(list3var)









  // TODO define
  // TODO concat . postfix op
  // TODO append
  // immutable
  // construct with Nil
  // sort with comparator
  // gather args in a list




}
