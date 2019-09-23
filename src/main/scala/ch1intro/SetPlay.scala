package ch1intro

import scala.collection.mutable

object SetPlay extends App {

  // var val += mutable


  var set = Set(1,2,3)

  def addIfNotThere(x : Int): Unit = {
    if (!set.contains(x)) {
      println("Fac ceva ca nu era acolo")
      set = set + x
    }
  }

  addIfNotThere(4)
  addIfNotThere(4)

}
