package old

import java.io.{BufferedReader, FileReader}

trait FunQueue[+T] {
  def enqueue[U >: T](x:U):FunQueue[U]
  def head(): T
  def dequeue(): FunQueue[T]
}

class QueueImpl[+T](intrareUser: List[T] = Nil, iesireUser: List[T] = Nil) extends FunQueue[T] {
  private def nuTrebuieInversata = iesireUser.nonEmpty
  val iesire = if (nuTrebuieInversata) iesireUser else intrareUser.reverse
  val intrare = if (nuTrebuieInversata) intrareUser else Nil

  override def enqueue[U >: T](x: U): FunQueue[U] = new QueueImpl[U](x :: intrare, iesire)
  override def head(): T = iesire.head
  override def dequeue(): FunQueue[T] = new QueueImpl(intrare, iesire.tail)
}

class Holder[+T](init:T) {
  private[this] var value:T = init
  def get: T = value
//  def set(newValue:T) = value = newValue
}

object Chapter19_TypeParameterization extends App{
  //un Int este un Any   ==> Holder[Int] este un Holder[Any] ==== Holder este COVARIANT in T ==> +T
  val unInt:Int = 1
  val unAny:Any = unInt

  val intHolder:Holder[Int] = new Holder[Int](1)
  val anyHolder:Holder[Any] = intHolder
//  anyHolder.set("S")////


  // refinement type {def close(): Unit} === "ceva care are o metoda close():Unit !!!!
  private def closeAfter[A <: {def close() : Unit}, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }

  // generice, higher-order function, curried ()(), refinement types, subtipare <:

  val fisier = new BufferedReader(new FileReader("""D:\workspace\scala-course\course\src\Chapter19_TypeParameterization.scala"""))
  val doi = closeAfter(fisier){ fisier => // B == Int
    val prima = fisier.readLine()
    println(prima)
    2
  }
  println(doi)

//
//  val intQ = new QueueImpl[Int]()
//  val anyQ:QueueImpl[Any] = intQ

  var q:FunQueue[Int] = new QueueImpl[Int]()
  q = q.enqueue(1)

  println(q.head())
  q = q.dequeue()

  q = q.enqueue(2)
  println(q.head())
  q.dequeue()
  q = q.enqueue(3)


  val nouaCoadaStranie = q.enqueue("String") //??!!!!
  val nouaCoadaStranieDouble = q.enqueue(true) //??!!!!


  val pubToString: Publication=>String = CustomerMine.getPublicationTitle _
  val pubToStringAsFunc: Function1[Publication,String] = CustomerMine.getPublicationTitle _
  val bookToAnyRef: Book => AnyRef = pubToString
  val bookToAnyRefAsFunc: Function1[Book, AnyRef] = pubToStringAsFunc


//  Function1[Publication,String] este un subtip al lui Function1[Book, AnyRef]
  println(pubToString.isInstanceOf[Book => AnyRef])

}

class Publication(val title:String)
class Book(title:String) extends Publication(title)

object Library {
  val books: Set[Book] = Set(new Book("ProgInScala"), new Book("Book of Eli"))

  def printBookList(info : Book => AnyRef): Unit = {
    for (book <- books) println(info(book))
  }
}

object CustomerMine {
  def getPublicationTitle(pub:Publication) = pub.title
  Library.printBookList(getPublicationTitle(_))
}
