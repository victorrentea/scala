package old

object Playground1 extends App {
  val acc = new ChecksumAccumulator

  println("Hello first main()")

  acc.add(1);  acc.add(2) // daca vreau sa ingramadesc doua instr pe o sg linie, atunci e NEVOIE de ;

  println(acc.checksum)

  println("a".length)
  println("a".toLowerCase)

  val s = "Prima linie " +
    "A doua linie"

  println(AltObiectStatic.echo("hello"))

  println(ChecksumAccumulator.calculateCRC("Gigi"))
  println(ChecksumAccumulator.calculateCRC("Gigi"))

  val ss =
    """ Usage pattern
      | -cp <classpath> - meanse
      | -D<arg> - JVM argument
    """.stripMargin
  println(ss)

  val phone = "0720019564"
  phone.matches("""\d{10}""")

  val i = 2

  val xs = "Telefonul meu este " + phone + ", oricand"
  val xs2 = s"Telefonul meu este $phone, oricand ${i * 2}"

  println(xs2)


  var y = new ClasaCuGetteriJavaStyle
  y.setCamp("as")

  val x = new ClasaCuGetteriSetteriAutoGenerati
  x.camp
  x.camp=("as")

  val z = new ClasaCuGetteriInStilulScala
  z.camp
  z.camp = "as"

  val p = new Person("John","Doe")
  p.fullName


  val someCollection = List(1,2,3)
  someCollection.filter(x=>Set(1,2,3).contains(x))  // creeaza 3 seturi
  val valoriPosibile = Set(1,2,3)
  someCollection.filter(x=> {
    println("o data")
    valoriPosibile.contains(x)
  })  // creeaza 3 seturi

  val sx: Ordering[Int] = null
//  println((1,"a") compareTo (2,"b"))

}

class ClasaCuGetteriJavaStyle {
  private var camp:String = _
  def getCamp:String = camp
  def setCamp(newVal:String) = camp = newVal
}

class ClasaCuGetteriSetteriAutoGenerati {
  var camp:String = _
}
// dpdv al API este identica cu:
class ClasaCuGetteriInStilulScala {
  private var campX:String = _
  def camp:String = campX
  def camp_=(newVal: String):Unit = campX = newVal
}

class Person(private val firstName:String, private val lastName:String) {
  def fullName = firstName + " " + lastName
}