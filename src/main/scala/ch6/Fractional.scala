package ch6

//class Rational {
//  public int numarator;
//  private int numitor;
//  public Rational(int numarator, int numitor) {
//    this.numarator = numarator;
//      def f()
//    def toString()
//    this.numitor = numitor;
//  }
//}
// === ~~~+ ===

// in semnatura clasei:
// val sau var => camp. Poate fi facut private
// nici nici => ca un parametru de consturctor

// val sau var definesc campuri
class Fractional private (val numarator:Int, private val numitor:Int) { //defaul value
  require(numitor != 0)
  def this(numarator: Int) = { // constructor overloaded.
    // Obligatoriu cheama constructorul default (cel din semnatura clasei): this(,,,)
    this(numarator,1)
  }
  println(s"Se naste un nou numar: $numarator pe $numitor") // corpul constructorului

  override def toString: String =
    if (numitor != 1) numarator + "/" + numitor
    else numarator.toString

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Fractional]) {
      val other = obj.asInstanceOf[Fractional]
      numitor == other.numitor && numarator == other.numarator
    } else {
      false
    }
  }
}
object Fractional { //companion object
  def apply(numarator: Int): Fractional = new Fractional(numarator)
  def apply(numarator: Int, numitor: Int): Fractional =
    new Fractional(numarator, numitor)
}

object FractionalPlay extends App {

  val zero = Fractional(0)

  println("campul: " + zero.numarator)
  println(zero)

  val doiPeCinci = Fractional(2,5)
  val doiPeCinci2 = Fractional(2,5)

  println(doiPeCinci == doiPeCinci2)

  // cmmdc  gcd
  // TODO ==
  // TODO +
  // TODO *
}