import org.scalatest.FunSuite

import scala.runtime.RichInt

class PotterTest extends FunSuite {
//  type IaoPasta
  type SetDeCarti = Array[(Int,Int)]
  type PromotionMatcher = SetDeCarti => Option[Set[Int]]
  def aiLuatDinGreseala3LaFel(arr: SetDeCarti):Option[Set[Int]] = {
    None
  }

  val arr = new Array[String](6)



  val promotiiWTF = Map[PromotionMatcher,Double]()
  val promotii = Map(
    9 -> 1.0,
    2 -> .95,
    3 -> .90,
    4 -> .80,
    5 -> .75,
    6 -> .70)
  val potter = new Potter(promotii)

  test("1x1") {
    println("Emma".##)
    assert(potter.price(Array(1->1)) == 8)
  }
  test("3x1") {
    assert(potter.price(Array(1->3)) == 3 * 8)
  }
  test("1,2") {
    assert(potter.price(Array(1->1, 2->1)) == 2 * 8 * .95)
  }
  test("1,2,3") {
    assert(potter.price(Array(1->1, 2->1, 3->1)) == 3 * 8 * .90)
  }
  test("1,2,3,4") {
    assert(potter.price(Array(1->1, 2->1, 3->1, 4->1)) == 4 * 8 * .80)
  }
  test("1,2,3,4,5") {
    assert(potter.price(Array(1->1, 2->1, 3->1, 4->1, 5->1)) == 5 * 8 * .75)
  }
  test("tot") {
    assert(potter.price(Array(1->2, 2->2, 3->2, 4->1, 5->1)) == 51.2)
  }
  test("tot*") {
    assert(potter.price(Array(6->2, 2->2, 3->2, 4->1, 5->1)) == 51.2)
  }
  test("tot*2") {
    assert(Math.abs(potter.price(Array(1->2, 2->2, 3->2, 4->1, 5->1,6->1)) - 55.2) < 0.1)
  }
  test("substr") { // aveai cartile (1 2 2), scoti cartile(1 si 2) si ramai cu (2)
    assert(potter.substract(Array(1 -> 1, 2 -> 2), Set(1, 2)) sameElements Array(2 -> 1))
  }
}

class Potter(val promotii:Map[Int,Double]) {

  val i:RichInt = 1
  def price(cart:Array[(Int, Int)]): Double =
    if (cart.isEmpty) 0d
    else allPromos(cart.map(_._1).toSet)
      .map(promoSet =>
        promoPrice(promoSet.length) +
        price(substract(cart, promoSet.toSet)))
      .min

  private def promoPrice(n: Int): Double = n * 8 * factor(n)
  private def factor(n:Int):Double = {
    promotii(n)
  }
  def substract(arr:Array[(Int,Int)], books:Set[Int]):Array[(Int,Int)] =
    arr.map(pair => ((pair._1,  if (books(pair._1)) pair._2-1 else pair._2)))
      .filter(_._2 >= 1)

  def allPromos(books:Set[Int]):List[List[Int]] =
    (1 to 6).iterator.flatMap(n => books.toList.combinations(n)).toList
}
