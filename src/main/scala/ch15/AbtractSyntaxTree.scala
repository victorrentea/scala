package ch15

object AbtractSyntaxTree extends App{
    val minusMinus = UnaryOp("-", UnaryOp("-", Literal("1")))

    println(minusMinus)
    println(minusMinus.simplify())
    println(UnaryOp("-", UnaryOp("+", Literal("1"))).simplify())
    println(UnaryOp("+", Literal("x")).simplify())
    println(BinaryOp("+", Literal("y"), Literal("0")).simplify())
    println(BinaryOp("+", Literal("0"), Literal("z")).simplify())
    println(BinaryOp("-", Literal("5"), Literal("5")).simplify())
    println(BinaryOp("-", Literal("5"), Literal("4")).simplify())
    println(BinaryOp("*", Literal("x"), Literal("0")).simplify())

//  Map<Integer,String> map
  val map = Map[String, String]("1" -> "a")
  println(isIntMap(map))
  println(isIntMap(List(1,2,3)))

  def isIntMap(ceva:Any):Boolean = ceva match {
    case x:Map[_,_] if x.keys.iterator.next.isInstanceOf[Int]=> true
    case _ => false
  }
}

abstract class Node {
  val label:String
  def simplify():Node = this match {
    case UnaryOp("-", UnaryOp("-", x)) => x
    case UnaryOp("+", x) => x
    case BinaryOp("+", x, Literal("0")) => x
    case BinaryOp("+", Literal("0"), x) => x
    case BinaryOp("*", _, Literal("0")) => Literal("0")
    case BinaryOp("-", Literal(x),  Literal(y)) if x == y => Literal("0")
    case x => x
  }
}
case class UnaryOp(override val label:String, child:Node) extends Node
case class Literal(override val label:String) extends Node
case class BinaryOp(override val label:String, left:Node, right:Node) extends Node



// 1 + 2*4
// -1
// a!= null ? 1: 2
// if (a!= null) 1 else 2

// +1
// !!x
// -(-1)
// x * 0
// x * 1
// x + 0
// x - x
// if (true) x else y