package ch1intro

import scala.collection.mutable

object MapPlay extends App {

  // immutable or mutable ?

  val map = mutable.Map(1.->("one"), 2 -> "two")

  // map.put(3,"three")
  map += 3 -> "three"
  println(s"map: $map")

  var immap = Map(1.->("one"), 2 -> "two")

  // map.put(3,"three")
  immap += 3 -> "three"
  println(s"immap: $immap")
}
