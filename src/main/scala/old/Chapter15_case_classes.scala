package old

import scala.collection.mutable

object Address {
  def apply(streetName:String, city:String) = new Address(streetName, city)
}
class Address(val streetName:String, val city:String) {
  override def equals(obj: scala.Any): Boolean =
    obj match {
      case other:Address =>
        (streetName, city) == (other.streetName, other.city)
      case _ => false
    }

  override def hashCode(): Int = (streetName, city).##

  override def toString: String = s"$streetName, $city"
}

case class Address2(streetName:String, city:String)
// Address si Address2 sunt absolut identice !!

object Chapter15_case_classes extends App {
  val add1 = Address2("Pipera","Bucuresti")
  val adrese = mutable.Set(add1)

  //add1.city = "Altu" // DO NOT EVER change the fields used in hashcode and equals of in instance in a Hash*
  println("Mai contine adresa? " + adrese(add1))

  adrese += Address2("Pipera","Bucuresti")

  println(adrese.size)

  println(add1)

  val clonaPerfecta = add1.copy()
  println(clonaPerfecta)

  val unPicModificat = add1.copy(city = "NoulOras")
  println(unPicModificat)
}
