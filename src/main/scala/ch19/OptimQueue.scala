package ch19

class OptimQueue {
  var s1:List[Int] = Nil
  var s2:List[Int] = Nil
  def push(e: Int) = {
    s1 = e :: s1
  }
  def pull(): Int = {
    val rez = s1.last
    s1 = s1.slice(0, s1.length - 1) // o(N)
    rez
  }
}


object OptimQueuePlay extends App {
  val q = new OptimQueue
  q.push(1)
  q.push(2)

  println(q.pull())
  println(q.pull())
}