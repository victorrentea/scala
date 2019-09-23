package old

abstract class Expr
case class Number(num:Double) extends Expr
case class Var(name:String) extends Expr
case class BinOp(operator: String, left:Expr, right:Expr) extends Expr
case class UnOp(operator:String, arg:Expr) extends Expr


object Chapter15_PatternMatching_AST extends App {

  val xPlus1 = BinOp("+", Var("x"), Number(1))
  println(xPlus1)

  val xMinus1 = xPlus1.copy(operator = "-")
  println(xMinus1)

  val ofensa1 = UnOp("-", UnOp("-", Var("x")))
  val ofensa2 = BinOp("+", Var("x"), Number(0))
  val ofensa3 = BinOp("*", Var("x"), Number(1))
  val ofensa4 = BinOp("*", Var("x"), Number(0))
  println(ofensa1)

  def simplify(expr: Expr) =
    expr match {
      case UnOp("-", UnOp("-", x)) => x
      case BinOp("+", x, Number(0)) => x
      case BinOp("*", x, Number(1)) => x
      case BinOp("*", _, Number(0)) => 0
      case bla => bla
    }

  println(simplify(ofensa1))
  println(simplify(ofensa2))

  val arr = Array("+40", "720019564","a","asdasd")
  val msg = arr match {
    case Array(cc, _*) => s"E numarul meu cu country code: $cc!"
    case _ => "E alt numar"
  }
  println(msg)

  val cevaNecunoscut_poateUnPair: Any = ("a", 2)
  cevaNecunoscut_poateUnPair match {
    case (a, b:Int) => println("primul" + a  + "  secund: " + (b+2))
    case _ => println("??!")
  }

//  val chars = Array("a","b","c")
}
