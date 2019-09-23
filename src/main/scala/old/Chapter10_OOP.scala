package old

object Element {
  def apply(line:String):Element = new LineElement(line)
  def apply(ch:Char, width:Int, height: Int):Element = new UniformElement(ch, width, height)
  def apply(lines: Array[String]):Element = new ArrayElement(lines)

  // override este OBLIGATORIU DACA suprascrii o metoda. Optional Daca o IMPLEMENTEZI
  private class ArrayElement(initialContent: Array[String]) extends Element { // private static class
    override val contents:Array[String] = uniformPad(initialContent)

    def uniformPad(lines:Array[String]):Array[String] = {
      val longestLine:String = lines.maxBy(_.length)
      val maxLength:Int = longestLine.length

      def padLine(line: String) = {
        val halfNoSpaces = (maxLength - line.length) / 2
        val halfPadding = " " * halfNoSpaces
        halfPadding + line + halfPadding
      }

      for (line <- lines) yield padLine(line)
    }

    // implementing an abstract function fara () cu o variabila/valoare !!!!
    // "Uniform access principle" inseamna ca implementarea unei fct abstract fara () poate fi un camp.
    // DPDV al clientului nu ar trebui sa conteze
    val name = "ArrayElem"
    //def name = "ArrayElem" -- NU poti implementa un VAL ABSTRACT cu un DEF, dar poti implementa un DEF ABSTRACT cu un VAL
  }

  //new ArrayElement(Array("rosu","galben","albastru"))

  private class LineElement(line:String) extends Element {
    def contents = Array(line)
    val name = "LineElem" // In scala final opreste override. Atat!
    override def width = line.length
    override def height = 1
  }

  private class UniformElement(ch:Char, width:Int, height: Int) extends Element {
    override def contents: Array[String] = Array.fill[String](height)(ch.toString * width)
    override val name: String = "UniformElem"
  }
}

abstract class Element {
  def contents: Array[String] // tine continutul linie cu linie
  def height(): Int = contents.length
  def width: Int = if (contents.isEmpty) 0 else contents(0).length
  val name:String
  def above(other: Element):Element = Element(contents ++ other.contents)
  def beside(other: Element):Element = {
    require(other.contents.length == contents.length)
    val shmecher = for ((a, b) <- contents zip other.contents) yield a + b
    Element(shmecher)
  }

  override def toString: String = contents.mkString("\n")
}


object Chapter10_OOP extends App {
  val primuElem = Element(Array("abc"))
//  println(primuElem.contents()) // nu compileaza pt ca functia ai declarat-o FARA ()

  // DAR daca ai declarat-o cu (), poti sa o apelezi si CU si FARA :
  primuElem.height()
  primuElem.height

//  val column1 = elem("Hello") above elem("***")
//  val column2 = elem("***") above elem("World")
//  val bloc = column1 beside column2
//  println(bloc)
  // hello ***
  //  *** world

//  println((new OClasaMica).i)

  val ue = Element('*', 3, 2)
  println(ue)

  val steagRO = Element("rosu") above Element("galben") above Element("albastru")
  println(steagRO)
  val steagFR = Element("rosu") above Element("maro") above Element("albastru")

  val sep = Element('*',2,3)

  val steaguri = steagRO beside sep beside steagFR
  println(steaguri)



  val strings = Array("rosu", "galben")

//  println(paddedStrings.mkString("\n"))

//  var orderList = Array(order1,order...)
//
//  val lastOrder = orderList.maxBy(_.creationDate)


  val stringList = Array("a","b","c")
  val intList = Array(1,2,3)

  println((stringList zip intList).mkString("\n"))
}






class CampPublicModificabil(var j:Int)
class CampPublicImutabil(val j:Int)
class CampPrivatImutabil(private val j:Int)
class CampPrivatModificabil(private var j:Int)
class CampImmutabilCareNuPoateFiSuprascrisInSubclase(final val j:Int)
class CampPublicCareSuprascrieCeva(override val j:Int) extends CampPublicImutabil(j)

class OClasaMica(final private val j:Int) {
  var s:String = _
  var i:Int = _
}