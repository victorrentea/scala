package ref.ch1intro

object ArraysPlay extends App {

  new One().halo()

}

class One {
  def halo(): Unit = {
    val arr = ttt

    for (i <- 0 until 3) {
      println(arr(i).toUpperCase())
      Console println 10
    }


    val apply = new TestApply
    println(apply("a"))
  }

//  private def ttt: Array[String] = {
//    val arr = new Array[String](3)
//    arr update(0, "a")
//    arr(1) = "b"
//    arr(2) = "c"
//    arr
//  }

  private def ttt: Array[String] = {
    Array("a", "b", "c")
  }
}


class TestApply {
  def apply(s:String): String = s.toUpperCase()
}
