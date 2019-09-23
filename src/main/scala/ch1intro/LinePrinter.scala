package ch1intro

import scala.io.Source

object LinePrinter extends App {

  //  def lineLengthLength(line:String):Int

  // final variable
  val fileName = """C:\workspace\scala\src\main\scala\ch1intro\LinePrinter.scala"""

  // NU pe poti numi Scala de veloper daca folosesti var nestins. Nu dai cu var ca te arzi.

  def printLineNice(fileName: String): Unit = {
    def lineLengthLength(line: String): Int = line.length.toString.length


    // in Scala fata de Java, tranformarile functionale de colectii
    // ruleaza imediat ce le aplici, nu lazy la .collect (ca in Javra)
    val maxLength = Source.fromFile(fileName).getLines()
      .map(lineLengthLength(_)) // underscore-ul tine poz primului parametru al fct anonime.
      .max
    println("max: " + maxLength)

    for (line <- Source.fromFile(fileName).getLines()) {
      val padding = " " * (maxLength - lineLengthLength(line))
      println(padding + line.length + " | " + line)
    }
  }

  def m(x: Int): Unit = {
    //    x = 2 // param metodelor sunt val-uri
  }

  new Joaca()./(1)
  new Joaca / (1)
  new Joaca / 1 //poti sa scoti parantezele din argumente pentru ca e unu singur
  new Joaca uau$(1, 2)
}

class Joaca {
  def /(x: Int): Unit = {
    println("Frate!")
  }

  def uau$(x: Int, y: Int): Unit = {
    println("Frate!")
  }
}