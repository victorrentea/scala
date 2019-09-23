package ch6

// val sau var definesc campuri
class Fractional(val numarator:Int, val numitor:Int = 0) { //defaul value
  println(s"Se naste un nou numar: $numarator") // corpul constructorului

  override def toString: String = numarator.toString
}



object FractionalPlay extends App {

  val zero = new Fractional(0)

  println("campul: " + zero.numarator)
  println(zero)

  val doiPeCinci = new Fractional(2,5)
}