package old

import java.util

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

//~@Data din Lombok
case class Trader(name: String, city: String) // default has field-by-field equals implemented

class CuValoare(private val valoare:Int) extends Ordered[CuValoare] {
  override def compare(that: CuValoare): Int = valoare.compareTo(that.valoare)
}

case class Transaction(trader: Trader, year: Int, value: Int)
  extends CuValoare(value)

object CollectionsPlay extends App {
  val raoul = Trader("Raoul", "Cambridge")
  val mario = Trader("Mario", "Milan")
  val alan = Trader("Alan", "Cambridge")
  val brian = Trader("Brian", "Cambridge")

  val transactions:List[Transaction] = List(
    Transaction(brian, 2011, 300),
    Transaction(raoul, 2012, 1000),
    Transaction(raoul, 2011, 400),
    Transaction(mario, 2012, 710),
    Transaction(mario, 2012, 700),
    Transaction(alan, 2012, 950)
  )

//  all_2011_transactions_sorted_by_value_desc
  println(transactions
    .filter(transaction => transaction.year == 2011)
//    .sortBy(t => t.value).reverse
//    .sortBy(_.value).reverse
//    .sortBy(-_.value)
//      .sortWith((t1,t2) => t1.value > t2.value)
      .sortWith(_.value > _.value) // boolean return
    .mkString("\n"))

//  unique_cities_of_the_traders
  println(transactions
    .map(_.trader.city)
//    .distinctBy(_.toUpperCase())
    .distinct
    .mkString("\n"))

//  traders_from_Cambridge_sorted_by_name
  println(transactions
    .map(_.trader)
    .filter(_.city == "Cambridge")
    .sortBy(_.name)
    .distinct // List[Trader]
    .mkString("\n"))

//  names_of_all_traders_sorted_joined cu ,
  println(transactions
    .map(_.trader.name) // List[String]
    .sorted
    .distinct // preserves order!!
    .mkString(",")
    )

  val list = List(1,1,6,9,3,9,1231,23223,1231)

//  new util.LinkedHashSet[Int](list);

//  are_traders_in_Milan
  println(transactions
    //    .map(_.trader)
    //    .filter(_.city == "Milan")
    //    .nonEmpty

    //    .map(_.trader)
    //    .find(_.city == "Milan")
    //    .nonEmpty

//    .map(_.trader).exists(_.city == "Milan")

    .exists(_.trader.city == "Milan")
  )

//  implicit def toNumeric(transaction: Transaction):NuInt = transaction.value
//  implicit def numeric(transaction: Transaction):
//    Numeric[Int] =

//  sum_of_values_of_transactions_from_Cambridge_traders
  println(transactions
    .filter(_.trader.city == "Cambridge")
    .map(_.value)
//    .sum
    .reduce(_ + _)
  )

//  max_transaction_value
  println(transactions.reduce((t1, t2) => if (t1.value > t2.value) t1 else t2)
    .value
  )

//  transaction_with_smallest_value
  println(transactions
//    .min) // merge doar pentru ca exista un supertip al lui Transaction (CuValoare) care e Ordered
    .minBy(_.value))


  val e:ArrayBuffer[Int] = ArrayBuffer()
  e+=1
  e-=1
//  println(e.min) // crapa la runtime !
  println(e.minOption)


//  fibonacci_first_10
//  1 1 2 3 5 8 13 21

//  @tailrec // NU MERGE
  def fib1(n:Int):List[Int] =
    if (n == 0) Nil
    else if (n == 1) 1 :: Nil
    else if (n == 2) 1 :: 1 :: Nil
    else {
      fib1(n-1) match {
        case x :: y :: tail => x + y :: x :: y :: tail
      }
    }

//  def fib2(n: Int): List[(Int, Int)] =
//    if (n == 1) 1->1 else
//    if (n==2) 2 -> 1 else


//  (a,b) => a+b
//  (1,1) => (b, a+b)   (1,2)   (2,3) (3,5)

//  (1 to 10).map(i => (i, 0))
//    .reduce((t1, t2) => (t1._1 + t2._1) -> 0)  //(i,0) (i+1, 0)

//  Stream.int

  println(fib1(10))

//  a_transaction_from_2012
//  uniqueCharactersOfManyWords






}
