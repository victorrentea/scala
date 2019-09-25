package ref.game2048

import java.lang.Math

import scala.util.Random

object Game extends App {
  val CELLS_PER_TURN = 3;
//  def f(a: (Int, Int)) = true

  val r = new Random()
  r.nextInt()
  println("HAlo!!")
  println(new Board)
  val b= new Board().putNumbers(Map(0 -> NumberCell(1), 3 -> NumberCell(4)))
  println(b)
  println(b.emptyIndexes.mkString(" "))

  val indexes = r.shuffle(b.emptyIndexes).take(3)
  val pairs = for (i <- indexes) yield i -> NumberCell(Math.pow(2, r.nextInt(3) + 1).toInt)
  println(pairs)
  val newPoints = Map.from(pairs)
  val b2 = b.putNumbers(newPoints)

  println(b2)

  val line = Array(2,2,4,0)
  (line zip line.drop(1)).foreach(println _)


  println(compact(List(2,2,4,4)))

  def compact(list:List[Int], zeros:Int = 0): List[Int] = list match {
    case Nil => if (zeros == 0) Nil else 0 :: compact(Nil, zeros - 1)
    case 0 :: rest => compact(rest, zeros + 1)
    case x :: y :: rest if x == y => x * 2 :: compact(rest, zeros + 1)
    case x :: rest => x :: compact(rest, zeros)
  }

  val orig: List[List[Int]] = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9, 10, 11, 12), List(13, 14, 15, 16))
  println(orig.mkString("\n"))
  println("----")
  println(rotate(orig).mkString("\n"))
//
  def rotate(m:List[List[Int]]): IndexedSeq[IndexedSeq[Int]] =
    for (i <- 0 to 3) yield for (j<- 0 to 3) yield m(j)(3-i)
}


//object Cell {
//  def Cell(value: Int): Cell = new NumberCell(value)
//  def Cell(): Cell = new EmptyCell
//}
trait Cell {
  def canSum(cell: Cell): Boolean
}
class EmptyCell extends Cell {
  override def canSum(cell: Cell): Boolean = false
  override def toString: String = " " * 4
}
case class NumberCell(private val value:Int) extends Cell{
  override def canSum(cell: Cell): Boolean =
    cell match {
      case _:EmptyCell => false
      case number:NumberCell => number.value == this.value
    }

  override def toString: String = value.toString.padTo(4, ' ')
}

class Board(private val data: Array[Cell] = Array.fill(16)(new EmptyCell())) {

//  println("new board : "+data.mkString(" "))
  def putNumbers(points: Map[Int, Cell]): Board = {
    new Board(data.zipWithIndex.map(t => points.getOrElse(t._2, t._1)))
  }
  def emptyIndexes: Array[Int] =
    data.zipWithIndex.filter(vi => vi._1.isInstanceOf[EmptyCell]).map(_._2)

//  def moveLeft(): Board = {
////    for (i )
//  }

  override def toString: String =
    data
      .map(_.toString)
      .grouped(4)
      .map(_.mkString(" "))
      .mkString("\n")

}
