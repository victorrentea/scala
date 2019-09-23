package ch4

object A {

  println(new A(1).v)
}

class A(val y: Int) {
  protected def a = 5

  private val v = 1

  println(y)

  def f(a: A): Boolean = {
    a.v == v
  }
//  val x: Int;
}
class B (override val y:Int) extends A(y) {
  override val a: Int = 15
}

object Play extends App {
  val a = new A(1)
//  a.y=2
//  a.a
  println(a.y)
}

