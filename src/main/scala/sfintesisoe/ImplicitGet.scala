package sfintesisoe

object ImplicitGet extends App{

  trait HasGet[A] {
    def get(a: A): Int
  }


  implicit val wrap: HasGet[Wrapper] = new HasGet[Wrapper] {
    def get(a: Wrapper): Int = a.i
  }

  def add1[A](a: A)(implicit hga: HasGet[A]): Int = hga.get(a) + 1
  add1(Wrapper(1))

  // din nou
  def add1Prost(a: {def id:Int}): Int = a.id + 1

  def add1Bine[T](a: T)(/*functie*/implicit convertToHasId:HasId[T]): Int =
    convertToHasId.getId(a) + 1

  implicit val convertorLaHasId: HasId[Strain] = (x:Strain) => x.id

  println(add1Bine(new Strain(13)))


  val a: () => Nothing = () => throw new Exception
  println("oare mai aj aici")
  println(a())
  println("oare mai aj aici2")
}

case class Wrapper(val i: Int)

//creez:
trait HasId[T] {
  def getId(x: T): Int
}

// nu poti sa o modifici
case class Strain(id:Int)