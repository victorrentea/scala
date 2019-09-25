package ch19

class OptimQueue {
  var incoming:List[Int] = Nil
  var outgoing:List[Int] = Nil

  def push(e: Int): Unit = {
    incoming = e :: incoming
  }
  def pull(): Int = {
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
  val q = new OptimQueue
  q.push(1)
  q.push(2)

  println(q.pull())
  println(q.pull())
}