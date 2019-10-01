package game2048

case class Value(n: Int) extends AnyVal {
//  require(n % 2 == 0)
  override def toString = n.toString
}

object BoardPlay extends App {
  val board = Board(0 -> Value(2),1->Value(2), 4->Value(2), 5->Value(16))
  println
  println(board)
  printCompact(Direction.UP)
  printCompact(Direction.DOWN)
  printCompact(Direction.LEFT)
  printCompact(Direction.RIGHT)

  private def printCompact(direction: Direction) = {
    println(s"\nCompacted to $direction")
    println(LineCompacter.compact(board, direction))
  }

  println
  println(board.rotateCW(1))
  println
  println(board.rotateCW(2))
  println
  println(board.rotateCW(3))
  println
  println(board.rotateCW(4))
}

object Board {
  def apply(points: Map[Int, Value]): Board =
    Board((0 until 16).map(i => points.getOrElse(i, Value(0))).toArray)

  def apply(points: (Int, Value)*): Board = apply(Map.from(points))
}

case class Board(data: Array[Value] = Array.fill(16)(Value(0))) {

  private def rotateCWOnce(): Board = Board(
    List(
      12, 8, 4, 0,
      13, 9, 5, 1,
      14, 10, 6, 2,
      15, 11, 7, 3)
    .map(data(_)).toArray)
  def rotateCW(times:Int): Board =
    (1 to 4 + times).foldRight(this)((i, board) => board.rotateCWOnce())

  def putNumbers(points: Map[Int, Value]): Board =
    new Board(data.zipWithIndex.map(t => points.getOrElse(t._2, t._1)))

  def emptyIndexes: Array[Int] =
    data.zipWithIndex.filter(vi => vi._1 == Value(0)).map(_._2)


  override def toString: String =
    data
      .map(_.toString)
      .grouped(4)
      .map(_.mkString(" "))
      .mkString("\n")

}

