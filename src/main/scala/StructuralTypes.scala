object StructuralTypes extends App {

  def add1(x: {def get: Int}): Int = 1 + x.get

  println(add1(new DatatorDeInturi))

}

// nu pot sa modific codul sa adaug extends X
class DatatorDeInturi {
  def get:Int = 6
}

trait X {
  def get: Int
}
