package game2048

import scala.util.Random

object Generator {
  def allNewValues(board:Board):Array[Map[Int,Value]] =
    for (four:Int <- board.emptyIndexes;
      two1 <- board.emptyIndexes
      if two1 != four;
      two2 <- board.emptyIndexes
      if two2 > two1 && two2 != four)
      yield Map(
        four -> Value(4),
        two1 -> Value(2),
        two2 -> Value(2)
      )

  def allNewBoards(board:Board): Array[Board] =
    allNewValues(board).map(p => board.putNumbers(p))

  val r = Random
  def pickRandomNewBoard(board:Board): Board = {
    val all = allNewBoards(board)
    all(r.nextInt(all.length))
  }

}

object GeneratorPlay extends App {
  val board = new Board {
    override def emptyIndexes = Array(1,2,3,4)
  }

  println(Generator.allNewValues(board).toList)
  println(Generator.allNewBoards(board))
  println(Generator.pickRandomNewBoard(board))
}
