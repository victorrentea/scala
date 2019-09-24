package ch12

abstract class AC1 {
  def m():String = "Halo"
}
abstract class AC2

trait T1 extends AC1 {
  override def m():String = "Salam alecum!"
}
trait T2 {
  def m(): String = "Alecum salam!"
}

class C1 extends AC1 with T1 /* with T2*/ {
}

// ------


class Stiva[T] {
  private var data: List[T] = Nil
  def push(elem: T): Unit = data ::= elem
  def pop(): T = {
    val rez = data.head
    data = data.tail
    rez
  }
}
trait DoublingPush extends Stiva[Int] {
  override def push(elem: Int): Unit = {
    println("#doubling")
    super.push(elem * 2)
  }
}
trait FilteringOddsPush extends Stiva[Int] {
  override def push(elem: Int): Unit = {
    println("#odd")
    if (elem % 2 == 0) super.push(elem)
  }
}
trait ALuMada extends DoublingPush with FilteringOddsPush{
  override def push(elem: Int): Unit = {
    println("#mada")
    super.push(elem)
  }
}

object Traits extends App {
  // TEMA pentru cititor.
//  val s = new Stiva[Int]  with FilteringOddsPush with DoublingPush with DoublingPush with FilteringOddsPush with ALuMada
//  val s = new Stiva[Int]  with FilteringOddsPush with DoublingPush with ALuMada
  val s = new Stiva[Int]  with FilteringOddsPush with DoublingPush
  s.push(1)
  s.push(2)
  println(s.pop())
  println(s.pop())


  val deTestat = new ObjDeDomeniu with FakeS3Loader
  println(deTestat.m())

  println(new C1().m())
  val cHacuit = new C1 with T1
  println(cHacuit.m())
}

class ObjDeDomeniu {
  val client = "ala pe bune"
  def m(): String = client.toUpperCase()
}
trait FakeS3Loader extends ObjDeDomeniu {
  override val client = "Tzeapa"
}


trait X1 {
  def m(): String = "a"
}
trait X2 extends X1{
  override def m(): String = "b"
}
trait C extends X1 with X2{

//  override m()
}
trait C2 extends X2 with X1 {

//  override m()
}