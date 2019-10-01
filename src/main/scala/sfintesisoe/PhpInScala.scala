package sfintesisoe

import java.text.ParseException

import scala.util.Try

object PhpInScala extends App {


  implicit def str2int(str: String): Int = Integer.parseInt(str)



  def sum(a:Int, b:Int) = a + b

  println(sum("1",2))
//  println(sum("a",2))


  println(Try{Integer.parseInt("foobar")}
    .recover({
      case _:NumberFormatException => 14
      case _ => 10
    }).map(_ / 2))
}
