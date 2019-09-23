package old


trait Abstract{
  def metoda:Int   // -- fix "abstract int metoda()" din Java
  val valoare:Int // "abstract int valoare()"

//  var variab:Int // Java: "abstract int valoare()" si "abstract void valoare_=(int newVal)"

  def variab:Int
  def variab_=(newVal:Int)
//  type T
}

class Concrete extends Abstract {
  def metoda = 1
  val valoare = 1
  var variab = 1 // varul de aici automat defineste getterul si setterul cerut
//  type T = String
}

class Iarba
class DiTate
abstract class Animal {
  type MancareAcceptabila
  def mananca(mancare: MancareAcceptabila) =
    println("Mananc " + mancare)
}
class Oaie extends Animal {
  override type MancareAcceptabila = Iarba
}
class Porc extends Animal {
  override type MancareAcceptabila = DiTate
}

object Directie extends Enumeration {
  val EST = Value
  val VEST = Value
  val SUD = Value
  val NORD = Value
}

object Chapter20_AbstractStuff extends App {

  val bisisica = new Oaie
  bisisica.mananca(new Iarba)

  val porcule = new Porc
  porcule.mananca(new DiTate)

  val ceMananceOOaie = new bisisica.MancareAcceptabila
  println(ceMananceOOaie)
  val ceManacaUnPorc = new porcule.MancareAcceptabila
  println(ceManacaUnPorc)

  def mergi(directie: Directie.Value): Unit = {
    println("Merg spre " + directie)
  }
  mergi(Directie.EST)
}
