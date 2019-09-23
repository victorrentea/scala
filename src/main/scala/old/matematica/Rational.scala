package old.matematica

class Rational(numarator2:Int, numitor2:Int) {
  // cod care ruleaza in constructorul default

  private val numarator:Int =  numarator2 / gcd(numarator2, numitor2)
  private val numitor:Int = numitor2 / gcd(numarator2, numitor2)
  require(numitor != 0)

  def this(numarator3:Int) = this(numarator3, 1)

  def +(other: Rational): Rational =
    new Rational(this.numarator * other.numitor + this.numitor * other.numarator, this.numitor * other.numitor)

  def *(other: Rational): Rational =
    new Rational(numarator * other.numarator, numitor * other.numitor)

  def *(i: Int): Rational = this * Rational(i)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String =
    if (numitor == 1)
      numarator.toString
    else {
      val sig = math.signum(numitor)
      s"${numarator * sig} / ${numitor * sig}"
    }

  override def equals(obj: scala.Any): Boolean =
    if (!obj.isInstanceOf[Rational]) false
    else {
      val other = obj.asInstanceOf[Rational]
      (this.numitor, this.numarator) == (other.numitor, other.numarator)
    }

  override def hashCode(): Int = (numitor, numarator).##
}

object Rational {
  def apply(numarator: Int, numitor: Int): Rational = new Rational(numarator, numitor)
  def apply(numarator: Int): Rational = new Rational(numarator)

}