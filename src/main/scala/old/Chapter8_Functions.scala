package old

import java.io.PrintStream

import scala.io.Source

object Chapter8_Functions extends App {

  def processFile(fileName: String, width:Int) = {
    def processLine(line:String) = { // local function
      if (line.length > width)
        println(fileName + ": " + line.trim) // fileName and width come from this
      // local function's clojure : metoda processFile care o contine
      // poti sa referi param de met, variab, campuri ale intantei in care esti
    }
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
    processLine(line)
  }

  processFile("src/main/scala/old/Chapter8_Functions.scala", 20)

//  val increase =
  val list:Array[Int] = Array(1,2,3)
  val isOdd = (e:Int) => e % 2 == 0
  // e => e % 2 == 0    este un "function literal"
  list.filter(isOdd)

  list.filter(e => e % 2 == 0) // scala compiler isi da seama ca e trebuie se fie de tip Int
  // pentru ca filter asteapta un ~Predicat<Int>


  var delta = 1
  val increaser = (x:Int) => x + delta

  println("Increaser1: " + increaser(3))

  delta = 10
  println("Increaser2: " + increaser(3))

  // o functie care primeste param sau intoarce o alta functie se
  // numeste "Higher Order Function"
  def makeIncrementer(): () => Int = {
    // () => Int  este o functie care nu ia param dar iti da un Int inapoi
    var currentValue = 0
    () => {
      currentValue += 1
      currentValue
    }
  }
  val inc = makeIncrementer()
  //aici metoda makeIncrementer s-a terminat
  // si a fost eliverata din stiva
  // UNDE MAMA MASII A RAMAS CURRENT VALEUUUU ?
  println(inc())
  println(inc())
  println(inc())
  println(inc())
  println(inc())
  // Scala pune in astfel de situatii currentValue in HEAP, nu pe STIVA

  ///////// end of horror


  ////// compact function forms
  val numere:Array[Int] = Array(-1,2,5,-7,3)
  numere.filter(x => x > 0).foreach(x => println(x))
  numere.filter(_ > 0).foreach(println(_))   // _ tine locul parametrilor, in ordinea in care vin

  numere.sortWith( (a, b) => a < b).foreach(println(_))
  numere.sortWith( _ < _ ).foreach(println(_))
  // asta merge pentru ca in fct de mai sus era a < b nu b < a !!!!

//  val lt = _ < _ // nu compileaza pentru ca Scala nu stie ce tip au _-rile
  val lt = (_:Int) < (_:Int)
  val ltAcelasi: (Int, Int) => Boolean = (_:Int) < (_:Int)
  val ltAcelasiMaiScurt: (Int, Int) => Boolean = _ < _

  /// LUNCH BREAK -----------------------

  def sum(a: Int, b: Int, c:Int): Int = a + b + c

//  val adunareFaraTip = sum // nu merge pentru ca Scala crede ca vreau sa invoc metoda sum fara parametrii - si asta nu se poate !
  val adunare: (Int,Int,Int) => Int = sum
  val sase = sum (1,2,3)
  val aplicarePartiala: (Int,Int,Int)=>Int = sum _  // underscore-ul tine locul unei intregi LISTE de parametrii
  // ca mai sus, se considera ca aplicarePartiala este o functie, care aici are ca argument aceasi lista de param
  println(aplicarePartiala)

  val sumaCu3: Int => Int = sum(1, _, 2)
  val sumaCu3Bis = sum(1, _:Int, 2)
  println(sumaCu3(5))

  def sumaCuLong(a:Int, b:Long):Long = a+b
  def methodReference = sumaCuLong _
  def methodReference2 = sumaCuLong(_:Int, _:Long)
  def methodReference3: (Int, Long) => Long = sumaCuLong(_, _)
  //toate 4 de mai sus au aceeasi semnatura !!!

  ////////////// acum aplica "UITARE" ///////////////////

  val arr = Array(1,2,3)
  var sum = 0
//  for (e <- arr) sum += e  // asta e old school'
//  arr.foreach(e => sum += e)
  arr.foreach(sum += _)
  println(s"suma: $sum")

  ////////// named params, default params

  def sumeaza(numere: Int*) = numere.sum
  val arrArgs=Array(1,2,3,4,5)
  println("Suma = " + sumeaza(arrArgs : _*))

  def speed(distance:Float, time:Float):Float = distance/time
  println(speed(100, 10))
  println(speed(distance=100, time=10))
  println(speed(time=10, distance=100))

  def printTime(out: PrintStream = System.out, divizor: Int) =
    out.println(s"Current time is ${System.currentTimeMillis()/divizor}")

  printTime(System.err, 1)
  //printTime(1000) // NU compileaza ca nu e nici o metoda cu Int ca prim parametru
  printTime(divizor=1000)



}
