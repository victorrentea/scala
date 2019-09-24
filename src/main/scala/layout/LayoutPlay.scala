package layout

object LayoutPlay extends App {
  println(Element("x2165387251"))
  println(Element('x', 2, 5))
  private val a = Element(Array("abcxxxx", "defxxxx", "ghixxxx"))
  println(a)
  private val b: Element = Element("abc") above Element('x', 2, 3)
  println(b)
  println(a beside b)

}

object Element {

  def apply(s: String): Element = new LineElement(s)

  def apply(arr: Array[String]): Element = new ParagraphElement(arr)

  def apply(character: Character,height: Int,width: Int): Element =
    new UniformElement(character, height, width)
}

trait Element {
  val width: Int
  val height: Int
  def asArray: Array[String]
  def above(other: Element): Element = new ParagraphElement(this.asArray++other.asArray)
  def beside(other: Element): Element = new ParagraphElement((this.asArray zip other.asArray).map(arrays => arrays._1 + arrays._2))
}

private class LineElement(content: String) extends Element {
  override def toString: String = content

  override val width: Int = content.length
  override val height: Int = 1

  override def asArray: Array[String] = Array(content)
}

private class UniformElement(character: Character,override val height: Int, override val width: Int) extends Element {
  override def toString: String = (computeLine + "\n") * height

  private def computeLine = character.toString * width

  override def asArray: Array[String] = (for(i<-0 until height) yield computeLine).toArray
}

private class ParagraphElement(lines: Array[String]) extends Element {

  require(lines.map(_.length).distinct.length == 1)

  override def toString: String = lines.mkString("\n")

  override val asArray: Array[String] = lines
  override val width: Int = lines.head.length
  override val height: Int = lines.length
}