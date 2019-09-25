package ch12

object ShapePlay extends App{

  val x = new Square(Point(1,1),1)
//  x.
}
case class Point(x:Int, y:Int)

trait WithDimensions {
  def topLeft:Point
  def bottomRight:Point

  def width:Int = rightX - leftX
//  def height:Int =
//  def area =
  def leftX: Int = topLeft.x
  def rightX: Int = bottomRight.x

}

class Square(override val topLeft:Point, edge:Int) extends WithDimensions {
  override def bottomRight: Point = Point(topLeft.x + edge, topLeft.y +edge)
}
class Rectange(override val topLeft: Point, width:Int, height:Int) extends WithDimensions {
  override def bottomRight: Point = Point(topLeft.x + width, topLeft.y + height)
}