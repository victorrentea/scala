package ch26

object GetterSetter extends App {

  val contor = new Contor()
  println(contor.v) // 0
  contor.v = 10
  println(contor.v)
  contor.v = -10
//  contor.v = -11
  println(contor.v)
}
// trebuie sa-i poti seta orice valoare "v" cu cond ca val sa nu fie
// negativa.
//daca se da negativa sa ramana la vechea valoare
class Contor(private var _v: Int = 0) {
  def v_=(value: Int):Unit = if (value >= 0) _v = value // if e folosit ca statement nu ca expresie
  def v: Int = _v // by default incercam sa facem totul val.
  // vom reusi daca clasele noastre sunt imutabile (sau case class)
  // Dar aici trebuie def pt ca se modifica starea interna a clasei

}


