package ch19

class OptimQueue[T] {
  var incoming:List[T] = Nil
  var outgoing:List[T] = Nil

  def push(e: T): Unit = {
    incoming = e :: incoming
  }
  def pull(): T = {
    reverse()
    val rez = outgoing.head
    outgoing = outgoing.tail
    rez
  }

  private def reverse(): Unit = {
    if (outgoing.isEmpty) {
      outgoing = incoming.reverse
      incoming = Nil
    }
  }
}


object OptimQueuePlay extends App {
  val q = new OptimQueue[Int]
//  val q2: OptimQueue[Any] = q
  q.push(1)
  q.push(2)

  println(q.pull())
  println(q.pull())

  def m(inturi: Supplier[Int]):Unit = {
    val i : Int = inturi.get()
    val orice: Supplier[Any] = inturi
    val a: Any = orice.get()
  }

  def m(cell:Cell[String]):Unit = {
//    val anyCell:Cell[Any] = cell
//    anyCell.set(1)
//    cell.get

//    List<String> stringList;
//    List l = stringList;//
//    l.add(1);
  }

  def gunoier(g: Gunoi[Any]) = {
    val s:String = "a"
    val a:Any = s

    val gunoiDeString: Gunoi[String] = g // deci g e un subtip de Gunoi[String]
  }
}
abstract class Supplier[+T] { // covariance:
  // daca B extends A atunci si Supplier[B] extends Supplier[A]
  // merg in aceeasi directie
  def get(): T
}
abstract class Gunoi[-T] { // contravariance:
  // daca B extends A atunci si Gunoi[A] extends Gunoi[B]
  // merg in directii diferite
  def aruncaLaGunoi(s: T)
}

abstract class Cell[T] {
  def set(t: T)
  def get:T
}


