package ref.ch1intro

object ListPlay extends App {

  val l1 = List(1, 2, 3)
  val l2 = List(4, 5, 6)

  //  val l3 = l1 ::: l2
  val l3 = l2.:::(l1)
  println(l3)

  val l1a = 0 :: l1
  println(l1a)

  val nillist = 1 :: 2 :: 3 :: Nil;
  println(nillist)

  var ll: List[String] = Nil
  for (a <- args) {
    ll = a :: ll
  }
  ll = ll.reverse
  ll = ll.sortWith((a,b) => a.toUpperCase() > b.toUpperCase())
  println(ll)
  println(ll(2))
}
