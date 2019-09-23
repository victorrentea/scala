package ch7

object MultiplicationTable extends App {
  def printMultiTable(): String = {
    def generateCell(i: Int, j: Int): String = {
      val prod = (i * j).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
    def generateLine(i: Int):String = (1 to 10).map(generateCell(i, _)).mkString("")

    val lines = for (i <- 1 to 10) yield generateLine(i)
    lines.mkString("\n")
  }

  println(printMultiTable())
}
