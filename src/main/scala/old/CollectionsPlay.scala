package old

case class Trader(name: String, city: String)

case class Transaction(trader: Trader, year: Int, value: Int)

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

  println(transactions
    .filter(_.year == 2011)
    .sortBy(_.value))
  println(transactions
    .map(_.trader.city)
    .distinct)

  println(transactions
    .map(_.trader)
    .filter(_.city == "Cambridge")
    .sortBy(_.name))

  println(transactions
    .map(_.trader)
    .distinct
    .sortBy(_.name)
    .mkString(","))

  println(transactions
    .map(_.trader).exists(_.city == "Milan")
  )

  println(transactions
    .filter(_.trader.city == "Cambridge")
    .map(_.value).foldLeft(0)(_ + _))

  private val bestTransaction = transactions
    .reduceOption((a, b) => if (a.value < b.value) b else a)
  println(bestTransaction)

//  println(transactions
//    .find(_.year == 2012).get)

  val words = List("abc", "bcd")
  println(words.flatMap(_.toCharArray).toSet)

  def ePrim(i:Int) ={
    Thread.sleep(10)
    print(".")
    Math.random() < 0.5
  };

  val nr = (1 to 10000).toList
  val primelePanan10 = nr
    .withFilter(_ < 10)
    .withFilter(ePrim(_))

  println("am construit")
  println(primelePanan10.map((x:Int) =>x))
  // def fibonacci_first_10()
  // def advanced_sum_using_consumer() =
  def fibFrom(a: Int, b: Int): Stream[Int] =
    a #:: fibFrom(b, a + b)

  println(fibFrom(1, 1).take(7))
}
