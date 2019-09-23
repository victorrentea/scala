package ch1intro

object TuplePlay extends App{

  // pair

  val tuple = (1,2,3,4)
  println(tuple._1)
  val tuplude2 = f((1,1,"a"))
  val (a,b) = f((1,1,"a")) // frate!! multireturn
  println(s"ab = $a, $b")

  def f(t:(Int,Int,String)): (Int, Int) = (t._1 + 1,t._2 + 2)


}

//class RaspunsMeu()
