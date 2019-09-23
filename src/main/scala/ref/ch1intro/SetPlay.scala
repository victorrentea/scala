package ref.ch1intro

import scala.collection.mutable

object SetPlay extends App {


  var immSet = Set("a", "b", "d");
  immSet += "c";
  println(immSet)

  val set = mutable.Set("a", "b", "d")
  set.add("c")
  set+="c"
  println(set)

}
