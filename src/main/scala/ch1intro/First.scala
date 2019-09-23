package ch1intro

//object First {
//  println("Halo")
//
//  // TODO print all args
//
//  // TODO sum
//
//  // TODO max
//
//}

//public static void main()


class First {
  // totul by default e public in scala
  // vreau sa va fortati sa scrieti functii fara { adica o singura expresie = programare FUNCTIONALA
  def sum(a: Int, b: Int): Int = a + b

  def max(a: Int, b: Int): Int = if (a>b) a else b
}
object First { //~ contine toatele metodele STATICE ale unei clase First
  def main (args: Array[String] ): Unit = {
    println("Hello Scala !")
    println(new First().sum(1,2))
    println(new First() max (1,2))

    for (a <- args) {
      println(a.toUpperCase())
    }
  }

}
