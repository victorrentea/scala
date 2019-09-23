package old

import java.io.File
import java.util.UUID

import scala.io.Source

object Chapter9_ControlAbstraction extends App {

  private def filesHere() = (new File("src/main/scala")).listFiles

  private def filesMatching(matches: (String) => Boolean):Array[File] = { // higher order func
    for (file <- filesHere() if matches(file.getName)) yield file
  }

  def filesEnding(suffix:String) = filesMatching(_.endsWith(suffix))
  def filesContaining(bucata:String) = filesMatching(_.contains(bucata))
  def filesRegex(regex: String) = filesMatching(_.matches(regex))

  println(filesEnding(".scala").mkString("=="))
  println(filesContaining("Chap").mkString("--"))
  println(filesRegex(".*\\d.*").mkString("--"))

////////////////////////////// CURYING ////////////////

//  def sum(a:Int)(b:Int) = a + b
  def sum(a:Int) = (b:Int) => a + b
//  val sumaCu2 = sum(2)_
  val sumaCu2Bis:Int =>Int = sum(2)
  //sum(1) -- ce e asta ?? e o fucntie care-l mai vrea pe "b"

  val cinci = sumaCu2Bis(3)
  println(cinci)

  //////////// LOAN PATTERN

  println(sum ( 2 ) ( 3 ) )
  println(sum { 2 } {
    println("Tzeapa!!")
    3
  } ) // oricand o functie asteapta o lista de param cu 1 sg param, poti inloc ( ) cu { }

//  tryWith(file) { file =>
//    file.readLine()
//  }

  val file = new File("src/main/scala/old/matematica/Rational.scala")
  println(file.isFile)

  // ---
/**/val source = Source.fromFile(file)
/**/try {
      source.getLines.map(_.toUpperCase).foreach(println)
    // daca functia println ia 1 param si o referi intr-un loc in care se asteapta o functie
    // care ia 1 param, poti sa uiti chiar si de _
/**/} finally {
/**/  source.close
/**/}
  // ---


  def tryWithFile(file:File)(stuffToDo: Source=>Unit) = {
    val source = Source.fromFile(file)
    try {
      stuffToDo(source)
    } finally {
      source.close
    }
  }

  // Loan Pattern pt ca metoda tryWithFile iti imprumuta un pic o resursa,
  // pe care apoi el e respo sa o elibereze/inchida ~= try() {} din Java
  tryWithFile(file){ source =>
    source.getLines.map(_.toUpperCase).foreach(println)
  }


  ///////////// APOTEOZA --- "byName parameters" = =======
  var assertionsEnabled = false

  def assert(test: => Boolean):Unit = {
    if (assertionsEnabled && !test) throw new AssertionError
  }

  //
  val a = 2
  assert(a==1)


  assert(1 / 0 == 1) // Nu apare division by zero pentru ca expr NU se mai evalueaza de loc
  // &&-ul din assert nu mai are nevoie sa evalueze param "test" de acolo

  // param: => Tip) in declaratia functiei inseamna ca
  // expresia data param acelei functii la invocare
  // se evalueaza
  // (1) DOAR LA FOLOSIREA EI, si
  // (2) DE FIECARE DATA CAND E FOLOSITA IN FCT

  val treiNumereDiferite = Array.fill[String](3)(UUID.randomUUID().toString)
  println(treiNumereDiferite.mkString(","))
  // pentru fiecare element din array se executa din NOU .randomUUID....
}

