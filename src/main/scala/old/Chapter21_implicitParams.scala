package old

//class ClasaMea(val s:String) extends Ordered[ClasaMea] { // echibalentul implem comparable
//  def compare(that: ClasaMea): Int = s compare that.s
//}
class ClasaMea(val s:String) {
  override def toString: String = ">>"+s
}


object Chapter21_implicitParams extends App {
  case class Rectangle(w:Int, h:Int)
  implicit class RectangleMaker(val width: Int) {
    def x(height:Int) = new Rectangle(width,height)
  }

  val list = List("az","cx","by")
  println(list.sorted) // ca la mama lui

  val ordineCiudata = Ordering.by((s: String) => s.reverse)
  println(list.sorted(ordineCiudata))

  val list2 = list.map(new ClasaMea(_))
  implicit val ordineaMea = Ordering.by((_: ClasaMea).s)
  println(list2.sorted) // sorted a gasit in scope un val implicit care se potriveste ca param

  val r: Rectangle = 3 x 4
  println(r)
}
