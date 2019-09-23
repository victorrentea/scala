package ch7

object MultiplicationTable extends App {
  def printMultiTable(): String = {
    def generateCell(i: Int, j: Int) = {
      val prod = (i * j).toString
      " " * (4 - prod.length) + prod
    }

    def generateLine(i: Int):String = {
      val cells = for (j <- 1 to 10) yield generateCell(i, j)
      cells.mkString("")
    }

    val lines = for (i <- 1 to 10) yield generateLine(i)
    lines.mkString("\n")
  }

  println(printMultiTable())
}
