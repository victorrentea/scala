package ch8

object ScalaWithNoBreaks extends App{
  def m(arr: Array[String]): Boolean = {

    for (s <- arr) {
      if (!s.startsWith("-") && s.endsWith(".scala"))
        return true
    }
    false
  }

  def m(n:Int):List[Int] = {
    val listaGoala:List[Int] = Nil
    val ceoFiAsta:List[Int]=
      if (n == 0) listaGoala
      else throw new NotImplementedError() // are tipul Nothing
    ceoFiAsta
  }

  println(m(0))
//  println(m(10))
//  println(m(1))


  println(m(Array("-d", "blabla", "-x.scala", "asdakdas.scala")))
}
