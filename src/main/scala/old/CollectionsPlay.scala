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

//  println(tra)

//  all_2011_transactions_sorted_by_value_desc



//  unique_cities_of_the_traders
//  traders_from_Cabridge_sorted_by_name
//  names_of_all_traders_sorted_joined
//  are_traders_in_Milano
//  sum_of_values_of_transactions_from_Cambridge_traders
//  max_transaction_value
//  transaction_with_smallest_value
//  fibonacci_first_10
//  a_transaction_from_2012
//  uniqueCharactersOfManyWords






}
