package ch6

// val sau var definesc campuri
class Fractional private (numarator:Int, numitor:Int) { //defaul value
  require(numitor != 0)
  def this(numarator: Int) = { // constructor overloaded.
    // Obligatoriu cheama constructorul default (cel din semnatura clasei): this(,,,)
    this(numarator,1)
  }
  println(s"Se naste un nou numar: $numarator pe $numitor") // corpul constructorului
  override def toString: String =
    if (numitor != 1) numarator + "/" + numitor
    else numarator.toString
}
object Fractional { //companion object
  def apply(numarator: Int): Fractional = new Fractional(numarator)
  def apply(numarator: Int, numitor: Int): Fractional =
    new Fractional(numarator, numitor)
}

object FractionalPlay extends App {

  val zero = Fractional(0)

//  println("campul: " + zero.numarator)
  println(zero)

  val doiPeCinci = Fractional(2,5)

  // TODO toString nicer
  // TODO ==
  // TODO +
  // TODO *
}