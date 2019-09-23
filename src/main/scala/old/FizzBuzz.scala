//package old
//
//class FizzBuzzTest extends FunSuite with BeforeAndAfter {
//
//
//  test("Array has 100 elements") {
//    assert(FizzBuzz.getFirstN(100).length == 100)
//  }
//  test("1st element is 1") {
//    assert(getElement(1) == "1")
//  }
//  test("2nd element is 2") {
//    assert(getElement(2) == "2")
//  }
//  test("3rd element is Fizz") {
//    assert(getElement(3) == "Fizz")
//  }
//  test("5th element is Buzz") {
//    assert(getElement(5) == "Buzz")
//  }
//  test("15th element is Fizz Buzz") {
//    assert(getElement(15) == "Fizz Buzz")
//  }
//  test("105th element is Fizz Buzz Whizz") {
//    assert(getElement(105) == "Fizz Buzz Whizz")
//  }
//  test("17 is whizz") {
//    assert(getElement(17) == "Whizz")
//  }
//
//
// private def getElement(index: Int): String = FizzBuzz.getFirstN(200)(index - 1)
//
//}
////tip functie: Int => Boolean    String
//object FizzBuzz{
//  val CONDITIE: Array[(Int => Boolean, String)] = Array(
//    ((i: Int) => i % 3 == 0)  -> "Fizz",
//    ((i: Int) => i % 5 == 0)  -> "Buzz",
//    ((i: Int) => i % 7 == 0 || i.toString.contains("7"))  -> "Whizz"
//  )
//  def getFirstN(n:Int):Array[String]= {
//
//    val arr = for (i <- 1 to n) yield {
//      val labels = for( pair <- CONDITIE  if pair._1(i))yield pair._2
//
//      if(labels.nonEmpty) labels.mkString(" ")
//      else i.toString
//    }
//    arr.toArray
//  }
//
//
//}
