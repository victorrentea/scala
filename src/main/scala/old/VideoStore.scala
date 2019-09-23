package old

import scala.collection.mutable.ArrayBuffer

abstract class Movie(val title: String){
  def computePrice(daysRented: Int):Double
  def computeBonus(daysRented: Int): Int = 1
}

class RegularMovie(title:String) extends Movie(title) {
  def computePrice(daysRented: Int) = if (daysRented > 2) 2 + (daysRented - 2) * 1.5 else 2
}

class ChildrenMovie(title:String) extends Movie(title){
  def computePrice(daysRented:Int) = if (daysRented > 3) 1.5 + (daysRented - 3) * 1.5 else 1.5
}

class NewReleaseMovie(title:String) extends Movie(title){
  def computePrice(daysRented: Int) = daysRented * 3
  override def computeBonus(daysRented: Int): Int = if (daysRented > 1) 2 else 1
}

class Rental(val movie: Movie, val daysRented: Int){
  def computePrice:Double = this.movie.computePrice(this.daysRented)
  def computeBonus(): Int = this.movie.computeBonus(this.daysRented)
}

class Customer(private val name: String) {
  private val rentals = new ArrayBuffer[Rental]()

  def addRental(arg: Rental): Unit = {
    rentals += arg
  }

  def statement(): String = {
    val triplets:ArrayBuffer[(Double, Int, String)] = for (rental <- rentals) yield processRental(rental)
    val totalPrice = triplets.map(triplet => triplet._1).sum
    val totalFidelityPoints = triplets.map(triplet => triplet._2).sum
    val result = createHeader + triplets.map(triplet => triplet._3).mkString + createFooter(totalPrice, totalFidelityPoints)
    result
  }
  private def processRental(rental:Rental)={
    (rental.computePrice,rental.computeBonus(),createStatementLine(rental))
  }

  private def createHeader = {
    "Rental Record for " + name + "\n"
  }
  private def createStatementLine(rental: Rental) = {
    s"\t${rental.movie.title}\t${rental.computePrice}\n"
  }

  private def createFooter(totalPrice: Double, frequentRenterPoints: Int) = {
     s"Amount owed is $totalPrice\nYou earned $frequentRenterPoints frequent renter points"
  }


}