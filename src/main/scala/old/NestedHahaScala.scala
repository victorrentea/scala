package old

class NestedHaha {
  class Inner
}
object NestedHaha {
  class Nested
}

object NestedHahaScala extends App {
  val outer = new NestedHaha
  val inner = new outer.Inner
  val nested = new NestedHaha.Nested
}
