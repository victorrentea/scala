package ch8

object Closures extends App{

  var x = 1
  def f(): Int = {
    x
  }
  println(f())

  x = 2
  println(f())


  def acumulator(): () => Int = {
    var v = 1
    () => {
      v = v + 1
      v
    }
  }

  val a: () => Int = acumulator()
  println(a())
  println(a())
  println(a())
  println(a())


}

