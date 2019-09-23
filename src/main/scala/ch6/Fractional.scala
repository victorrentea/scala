package ch6

//class Rational {
//  public int numarator;
//  private int numitor;
//  public Rational(int numarator, int numitor) {
//    this.numarator = numarator;
//    this.numitor = numitor;
//      def f()
//    def toString()
//  }
//}
// === ~~~+ ===

// in semnatura clasei:
// val sau var => camp. Poate fi facut private
// nici nici => ca un parametru de consturctor

// val sau var definesc campuri
class Fractional private(numa: Int, numi: Int) { //defaul value
  require(numi != 0)
  private val numarator = numa / gcd(numa, numi)
  private val numitor = numi / gcd(numa, numi)

  def this(numarator: Int) = { // constructor overloaded.
    // Obligatoriu cheama constructorul default (cel din semnatura clasei): this(,,,)
    this(numarator, 1)
  }

  println(s"Se naste un nou numar: $numarator pe $numitor") // corpul constructorului

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String =
    if (numitor != 1) numarator + "/" + numitor
    else numarator.toString

  override def equals(obj: Any): Boolean = {
    obj match {
      case other: Fractional =>
        numitor == other.numitor && numarator == other.numarator
      case _ => false
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

//  println("campul: " + zero.numarator)
  println(zero)

  val doiPeCinci = Fractional(4, 10)
  val doiPeCinci2 = Fractional(2, 5)

  println(doiPeCinci == doiPeCinci2)

  // TODO cmmdc  gcd
  // TODO +
  // TODO *
}

