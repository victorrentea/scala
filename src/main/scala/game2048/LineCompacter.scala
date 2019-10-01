package game2048

object Direction {
  case object UP extends Direction(3)
  case object DOWN extends Direction(1)
  case object LEFT extends Direction(0)
  case object RIGHT extends Direction(2)
}
sealed class Direction(val cwToLeft:Int)

object LineCompacter {

  private def linesLists(board: Board): List[List[Int]] = board.data.grouped(4).map(_.map(_.n).toList).toList

  def compact(board: Board, direction: Direction): Board = {
    compactLeft(board.rotateCW(direction.cwToLeft)).rotateCW(-direction.cwToLeft)
  }

  def compactLeft(board: Board):Board = {
    Board(linesLists(board).flatMap(compactLeft).map(Value).toArray)
  }

  def compactLeft(list: List[Int]): List[Int] = {
    shiftLeft(list) match {
      case 0 :: rest => compactLeft(rest) :+ 0
      case x :: y :: rest if x == y => (x + y :: compactLeft(rest)) :+ 0
      case x :: rest => x :: compactLeft(rest)
      case Nil => Nil
    }
  }

  def shiftLeft(list: List[Int]): List[Int] = list match {
    case 0 :: rest => shiftLeft(rest) :+ 0
    case x :: rest => x :: shiftLeft(rest)
    case Nil => Nil
  }
}