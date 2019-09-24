package old

import scala.util.Random

object LazyVal extends App {
  val x = methodCall()


  def methodCall(): Int = {
    println("generez random")
    new Random().nextInt()
  }
  println("Start")
  println(x)
  println(x)
  println(x)
}
