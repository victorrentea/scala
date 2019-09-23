package old

import java.time.{LocalDate, Month}
// diferenta intre interfata si clasa abstracta:
// in Java: nu poti extinde doua clase abstract, dar poti implem 2 interf
// In java7: (1) O interfata: nu are met concrete. (2) Nu are campuri, ci doar constante
// In java8: (1) Nu are campuri, ci doar constante

class Point(val x:Int, val y:Int)

//abstract class Shape { // poate fi si abstract class fara probleme
trait Shape {
  val topLeft:Point // ~= constanta intr-o interfata
  val bottomRight:Point
  def width:Int = bottomRight.x - topLeft.x
  def height:Int = topLeft.y - bottomRight.y

  var color:String = "white" // asta este o abominatie in Java; nu poti sa ai campuri de instanta modificabile in interfete in Java
}


class Square(override val topLeft:Point, val edge:Int) extends Shape {
  override val bottomRight: Point = new Point(topLeft.x+edge, topLeft.y-edge)
}

//---------------------------------

class Student(val firstName:String, val lastName:String, val birthDate:LocalDate) extends Ordered[Student] {
  override def compare(that: Student): Int = {
    if (lastName != that.lastName)
      lastName.compareTo(that.lastName)
    else
      firstName.compareTo(that.firstName)
  }
}

object Chapter12_Traits extends App {
  val CONST=1
  val sq = new Square(new Point(3,3), 2)
  println(sq.width)
  println(sq.height)

  val gigel = new Student("Gigel", "Petrescu", LocalDate.of(1986,Month.AUGUST,15))
  val mihaita = new Student("Mihaita", "Petrescu", LocalDate.of(1987,Month.AUGUST,15))

  if (gigel < mihaita) {
    println("Gigel vine primul la catalog")
  }

  val studenti = Array(gigel, mihaita)
  val sortatiDupaNastere:Array[Student] = studenti.sortBy(student => student.birthDate)(_.compareTo(_))
  println(sortatiDupaNastere.mkString(","))
}
