package ch26

object GetterSetter extends App {

  val contor = new Contor()
  println(contor.getV()) // 0
  contor.setV(10)
  println(contor.getV())
  contor.setV(-10)
//  contor.v = -11
  println(contor.getV())
}
// trebuie sa-i poti seta orice valoare "v" cu cond ca val sa nu fie
// negativa.
//daca se da negativa sa ramana la vechea valoare
class Contor(private var v: Int = 0) {
  def setV(value: Int):Unit = if (value >= 0) v = value // if e folosit ca statement nu ca expresie
  def getV(): Int = v

}


