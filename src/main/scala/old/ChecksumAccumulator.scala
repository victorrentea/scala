package old

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum: Int = ~ ( sum & 0xFF) + 1
  // conventia Scala este ca daca o functie
  // nu produce side-eeffcturi (nu muteaza stare) si nu ia parametrii
  // , sa fie declarata fara ()
}
object ChecksumAccumulator {
  val cache = mutable.Map.empty[String, Int]

  def calculateCRC(s:String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val crc = doComputeCRC(s)
      cache += s -> crc
      crc
    }
  }

  private def doComputeCRC(s: String): Int = {
    println("caculez tata!")
    val acc = new ChecksumAccumulator
    for (ch <- s.toCharArray) {
      acc.add(ch.toByte)
    }
    acc.checksum
  }
}


object AltObiectStatic { // asta e un Singleton standalone object
  println("Acum ma creez") // similar cu un bloc static {}
  def echo(s:String):String = s
  // o metoda a unui object este ~= o met statica
}
