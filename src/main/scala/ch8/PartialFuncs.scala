package ch8

import java.io.{FileWriter, Writer}

object PartialFuncs extends App {

  def sum3(a: Int, b: Int, c: Int): Int = a + b + c

  def sum2(a: Int, b: Int): Int = sum3(a, b, 0)

  def sum2bis = sum3(_, _, 0)

  def plusN(n: Int)(x: Int) = n + x

  val plus10: Int => Int = plusN(10)
  println(plus10(2))

  //  try (Writer writer = new FileWriter("a.text")) {
  //
  //  }
//  tryWith(new FileWriter("a.txt")) (writer => {
  tryWith(new FileWriter("a.txt")) { writer =>
    println("chestii")
    writer.write("text")
  }

  def tryWith(writer: Writer)(todo: Writer => Unit): Unit = {
    try {
      todo(writer)
    }
    finally {
      writer.close()
    }
  }
}


