package old

object LazyVals extends App {
  println("1")
  val a = new Incercare
  println("2")
  println(a.x)
  println("3")
  println(a.x)
}

class Incercare {
  lazy val x = callHeacyMethod

  def callHeacyMethod = {
    println("Calulez")
    System.currentTimeMillis()
  }
}


