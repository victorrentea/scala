package old
import matematica._

import old.matematica.Rational

object RationalPlay extends App {

  val oneHalf = new Rational(1, 2)
  val one = new Rational(2, 2)
  //  val inf = new Rational(1, 0)
  println(oneHalf)

  val twoThirds = new Rational(2, 3)
  println(oneHalf + twoThirds)
  println(oneHalf + oneHalf)

  println(new Rational(1, 6) * new Rational(3, 1))
  println((oneHalf + twoThirds) * oneHalf)
  println(oneHalf * new Rational(2))
  println(new Rational(-1, 2))
  println(new Rational(1, -2))
  println(Rational.apply(-1, -2))
  println(Rational(-1, -2))
  println(Rational(1, 2) * 2)

  println(Rational(1, 2) * 2)

  println(intToRationalCaremaz(2) * Rational(1, 2))
  println(2 * Rational(1, 2)) // conversia automata a receptorului unei metode

  // Scala cauta vreo conversie implicita de la Int la X
  // asa incat X sa aiba operatia *(Rational)
}
