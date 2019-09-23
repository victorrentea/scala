package old

object TablaInmultirii extends App {

  def printMultiTable(): String = {
    def generateLine(i: Int): String = {
     val lineElements = for (j <- 1 to 10) yield {
        val prod = (i * j).toString
        val spaces = " " * (4 - prod.length)
        spaces + prod
      }
     lineElements.mkString("")
    }
    val table = for (i <- 1 to 10) yield generateLine(i)
    table.mkString("\n")
  }
  print(printMultiTable())
}
