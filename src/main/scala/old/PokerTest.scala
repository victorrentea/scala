package old

object Culoare extends Enumeration {
  //final static
  val PICA, CARO, INIMA, TREFLA = Value

  def apply(s :String) = s match {
    case "C" => CARO
    case "P" => PICA
    case "T" => TREFLA
    case "I" => INIMA
    case _ => throw new IllegalArgumentException
  }
}

object Valoare{
  val VALID_VALUES = List("2","3","4","5","6","7","8","9","10","J","Q","K","A") // ordonate crescator va valoare
  implicit def convertFromString(s: String):Valoare = new Valoare(s)
  implicit val valoareOrdering = Ordering.by((_:Valoare).index)
}
case class Valoare private(index: Int) {
  require(index < Valoare.VALID_VALUES.size && index > -1)
  def this(nr: String) = {
    this(Valoare.VALID_VALUES.indexOf(nr))
  }

  override def toString: String = Valoare.VALID_VALUES(index)
}
case class Carte(valoare:Valoare, culoare:Culoare.Value) extends Ordered[Carte]{
  override def compare(that: Carte): Int = this.valoare.index.compareTo(that.valoare.index)
}
object Carte {
  implicit def convertFromString(s: String): Carte = {
    val valoare = s.substring(0, s.length - 1)
    val culoare = Culoare(s(s.length - 1).toString)
    new Carte(valoare, culoare)
  }
}

case class Mana (carti:Set[Carte]) extends Ordered[Mana]{
  val orderedCards = carti.toList.sorted
  override def compare(that: Mana): Int = {
    val firstOrd = Ordering.by((_: Mana).evaluate)
    val cardOrdering:Ordering[Mana] = (0 until 5).toArray
      .map(index => Ordering.by((mana:Mana) => mana.orderedCards(index)))
      .reduceLeft(_ orElse _)
    val compositeOrd = firstOrd orElse cardOrdering
    compositeOrd.compare(this, that)
  }
  // 1) formatia e diferita
  // 2) maximum dintre cartile intrate in formatie
  // 3) maximul din restul de carti

  def evaluate: Formatie[_] = {
    Array(
      tryVarza(),
      tryOPereche(),
      try2Perechi(),
      try3Bucati(),
      tryQuinta(),
      tryCuloare(),
      tryFull(),
      tryCareu(),
      tryQuintaRoiala()

    ).filter(_.isDefined)
      .last
      .get
  }

  private val valori = carti.map(_.valoare)

  def tryVarza() = Some(Varza(valori.max))
  def tryOPereche():Option[OPereche] = {
    val perechiDe2 = carti.groupBy(_.valoare).values.map(_.toList).filter(_.size == 2).toList
    if (perechiDe2.size != 1) None else Some(OPereche(perechiDe2.head(0).valoare))
  }
  def try2Perechi():Option[DouaPerechi] = {
    val perechiDe2 = carti.groupBy(_.valoare).values.map(_.toList).filter(_.size == 2).toList
    if (perechiDe2.size != 2) None else Some(DouaPerechi(perechiDe2(0).head.valoare, perechiDe2(1).head.valoare))
  }
  def try3Bucati():Option[TreiBucati] = {
    carti.groupBy(_.valoare).values.map(_.toList).find(_.size == 3).map(list => TreiBucati(list.head.valoare))
  }

  def tryQuinta():Option[Quinta] = {
    val allUnique = valori.size == 5
    val delta = valori.max.index - valori.min.index == 4
    if (allUnique && delta) Some(Quinta(valori.max)) else None
  }

  def tryCuloare():Option[CuloareMana] = {
    if (carti.map(_.culoare).size > 1) None
    else Some(CuloareMana(valori.max))
  }

  def tryFull():Option[Full] = {
    if (tryOPereche().isDefined && try3Bucati().isDefined) {
      Some(Full(try3Bucati().get.valoare, tryOPereche().get.valoare))
    } else None
  }

  def tryCareu():Option[Careu] = {
    carti.groupBy(_.valoare).values.map(_.toList).find(_.size == 4).map(list => Careu(list.head.valoare))
  }

  def tryQuintaRoiala():Option[QuintaRoiala] = {
    if (tryQuinta().isDefined && tryCuloare().isDefined) {
      Some(QuintaRoiala(carti.max.valoare))
    } else None
  }
}

object Mana {
  def apply(carti: Carte*): Mana = new Mana(carti.toSet)
  implicit def apply(s:String) = new Mana(s.split("-").map(Carte.convertFromString).toSet)
}
abstract class Formatie[ME <: Formatie[ME]](val rank: Int) extends Ordered[Formatie[_]] {
  override final def compare(that: Formatie[_]): Int =
    if (that.rank != this.rank)
      this.rank compareTo that.rank
    else
      specificOrdering.compare(this.asInstanceOf[ME], that.asInstanceOf[ME])

  def specificOrdering:Ordering[ME]
}

final class CompositeOrdering[T]( val ord1: Ordering[T], val ord2: Ordering[T] ) extends Ordering[T] {
  def compare( x: T, y: T ):Int = {
    val comp = ord1.compare( x, y )
    if ( comp != 0 ) comp else ord2.compare( x, y )
  }
}
object OrderingImplicits {
  implicit class OrderingOps[T](val ord:Ordering[T]) extends AnyVal {
    def orElse(ord2: Ordering[T]) = new CompositeOrdering[T](ord, ord2)
  }
}

case class Varza(valoare: Valoare) extends Formatie[Varza](0) {
  override def specificOrdering: Ordering[Varza] = Ordering.by(_.valoare)
}
case class OPereche(valoare:Valoare) extends Formatie[OPereche](1) {
  override def specificOrdering: Ordering[OPereche] = Ordering.by(_.valoare)
}
case class DouaPerechi(valoare1:Valoare, valoare2:Valoare) extends Formatie[DouaPerechi](2) {
  def maxVal = valoare1.index max valoare2.index
  def minVal = valoare1.index min valoare2.index
  override def specificOrdering: Ordering[DouaPerechi] = Ordering.by((x:DouaPerechi) => (x.maxVal, x.minVal))
}
case class TreiBucati(valoare: Valoare) extends Formatie[TreiBucati](3) {
  override def specificOrdering: Ordering[TreiBucati] = Ordering.by(_.valoare)
}
case class Quinta(maxValoare: Valoare) extends Formatie[Quinta](4) {
  override def specificOrdering: Ordering[Quinta] = Ordering.by(_.maxValoare)
}
case class CuloareMana(maxValoare: Valoare) extends Formatie[CuloareMana](5) {
  override def specificOrdering: Ordering[CuloareMana] = Ordering.by(_.maxValoare)
}
case class Full(tripleCard: Valoare, pairCard: Valoare) extends Formatie[Full](6) {
  override def specificOrdering: Ordering[Full] = Ordering.by((full:Full)=>(full.tripleCard.index, full.pairCard.index))
}
case class Careu(valoare: Valoare) extends Formatie[Careu](7) {
  override def specificOrdering: Ordering[Careu] = Ordering.by(_.valoare)
}
case class QuintaRoiala(valoareMax: Valoare) extends Formatie[QuintaRoiala](8) {
  override def specificOrdering: Ordering[QuintaRoiala] = Ordering.by(_.valoareMax)
}



//class PokerTest extends FunSuite with BeforeAndAfter {
//
//  test("Varza mare > Varza mica") {
//    assert(Mana("2P-4T-5T-6T-7T") < Mana("2P-4T-5T-6T-8T"))
//  }
//  test("Varza idem == Varza idem") {
//    assert(Mana("2P-4T-5T-6T-7T").compareTo(Mana("2P-4T-5T-6T-7P")) == 0)
//  }
//  test("1 pereche > Varza") {
//    assert(Mana("2P-2T-5T-6T-7P") > Mana("2P-4T-5T-6T-7T"))
//  }
//  test("1 pereche Mare > 1 pereche mica") {
//    assert(Mana("3P-3T-5T-6T-7P") > Mana("2P-2T-5T-6T-10T"))
//  }
//  test("2 perechi > 1 pereche ") {
//    assert(Mana("3P-3T-5T-5P-7P") > Mana("10P-10T-5T-6T-9T"))
//  }
//  test("2 perechi mari > 2 perechi mici ") {
//    assert(Mana("3P-3T-10T-10P-7P") > Mana("2P-2T-5T-5P-10T"))
//  }
//  test("2 perechi idem + carte mare > 2 perechi idem") {
//    assert(Mana("3P-3T-10T-10P-7P") > Mana("3P-3T-10T-10P-6P"))
//  }
//  test("3 bucati > 2 perechi ") {
//    assert(Mana("3P-3T-3C-5P-7P") > Mana("10P-10T-5T-5C-3T"))
//  }
//  test("3 bucati mari > 3 bucati mici ") {
//    assert(Mana("3P-10T-10C-10P-7P") > Mana("2P-2T-2C-5P-10T"))
//  }
//  test("Quinta > 3 bucati ") {
//    assert(Mana("2P-3T-4C-5P-6P") > Mana("3P-3T-3C-5P-7P"))
//  }
//  test("Quinta Mare > Quinta mica") {
//    assert(Mana("3T-4C-5P-6P-7C") > Mana("2P-3T-4C-5P-6P"))
//  }
//  test("Culoare > Quinta ") {
//    assert(Mana("2P-6P-7P-KP-JP") > Mana("2P-3T-4C-5P-6P"))
//  }
//  test("Culoare Mare > Culoare Mica") {
//    assert(Mana("2P-6P-7P-KP-JP") > Mana("2C-6C-7C-QC-JC"))
//  }
//  test("Full > Culoare") {
//    assert(Mana("2P-2C-2I-JT-JP") > Mana("2P-6P-7P-KP-JP"))
//  }
//  test("Careu > Culoare") {
//    assert(Mana("2P-2C-2I-2T-JP") > Mana("2P-2C-2I-JT-JP"))
//  }
//  test("Quinta Roiala > Careu") {
//    assert(Mana("2P-3P-4P-5P-6P") > Mana("2P-2C-2I-2T-JP"))
//  }
//}