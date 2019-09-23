package old

object PrimeNumbers extends App {


  private def isPrim(num: Int): Boolean = {
    (2 until num).forall(num % _ != 0)
  }

  private def nrPrimePanaLa(num: Int) = {
    (2 to num).filter(isPrim)
  }

  def nrPrime(num: Int): Int = {
    val numbers = nrPrimePanaLa(num)
    numbers.foreach(println)
    val count  = numbers.length
    println(s"Pana la $num sunt $count numere prime.")
    count
  }



  nrPrime(10000)

}