package old

class Telefon(private val countryCode:String, private val localNumber:String) {

  override def equals(obj: scala.Any): Boolean =
    if (!obj.isInstanceOf[Telefon]) false
    else {
      val other = obj.asInstanceOf[Telefon]
      (this.countryCode, this.localNumber) == (other.countryCode, other.localNumber)
    }

//  override def hashCode(): Int = countryCode.## * 17 + localNumber.##
  override def hashCode(): Int = (countryCode, localNumber).##

  override def toString: String = s"$this.countryCode $this.localNumber"
}

object TelefonPlay extends App {
  val t1 = new Telefon("+4", "0720019564")
  val t2 = new Telefon("+4", "0720019564")
  println("t1.equals(t2) (Java-style)" + (t1 == t2))
  println("t1 == t2 (Java-style) ?: " + (t1 eq t2)) // asta e == din Java

  println("hashul t1 = " + t1.##)
  println("hashul t2 = " + t2.##)
  val set = Set(t1)
  println("contine? " + set(t2)) // pura intamplare, deoarece t1## != t2##

  for (i <- 0 to 2) println(i)
}