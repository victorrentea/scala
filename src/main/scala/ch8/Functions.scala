package ch8

import java.util.concurrent.Executors

import scala.concurrent.Future

object Functions extends App {

  def m(): Unit = {
    val functieInVariabila = () => {
      println("ia-o si pe asta")
    }

    functieInVariabila()
  }

  m()

  val arr = Array(
    FullName("Monica", { // oriunde trebuie o valoare/expresie poti pune un bloc {}
      println("FRATE:!!")
      "Tudose"
    }),
    FullName("Corina", "Tudose"),
    FullName("Jonh", "Doe")
  )

  println(arr.sortWith((a, b) => compareNames(a, b)).mkString("\n"))
  println(arr.sortWith(compareNames(_, _)).mkString("\n"))
  println(arr.sortWith(compareNames(_, _)).mkString("\n"))
  println(arr.sortWith(compareNames).mkString("\n"))

  private def compareNames(a: FullName, b: FullName) = {
    if (a.lastName != b.lastName) a.lastName < b.lastName
    else a.firstName < b.firstName
  }

  //  val lt  = _ < _ // nu compileaza pentru ca scala nu stie ce tipuri au param, deci nu poate stii daca are definit <
  //  val lt: (Int,Int)=> Boolean = _ < _
  val lt = (_: Int) < (_: Int)
  println(Array(1, 3, 2).sortWith(lt).mkString(","))
  println(Array(1, 3, 2).sortWith(_ < _).mkString(","))
  println(Array(FullName("a", "b")).sortWith(_ < _).mkString(","))
  println(Array(FullName("a", "b"),FullName("a", "c")).sorted.mkString(","))

//  implicit val executionContext = Executors.newFixedThreadPool(2)
//  Future {
//  }(executionContext) -- nu e necesar caci in semnatura functiei e marcat param ca implicit

  implicit val ordr = new CustomerComparator

  println(Array(Customer("b"), Customer("a"),Customer("c")).sorted.mkString(","))
}
class CustomerComparator extends Ordering[Customer] {
  override def compare(x: Customer, y: Customer): Int = x.name compareTo y.name
}

case class Customer(name:String)

case class FullName(firstName: String, lastName: String) extends Ordered[FullName] {
  //  def <
  //  def >
  //  def<=
  //  dev >=
  override def compare(that: FullName): Int = {
    val last = lastName.compareTo(that.lastName)
    if (last != 0) last
    else firstName.compareTo(that.firstName)
  }
}
