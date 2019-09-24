package ch8

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
}

class Customer

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
