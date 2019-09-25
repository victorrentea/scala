package ch26

import scala.util.matching.Regex

object Extractor extends App {
  val emailPattern: Regex = "(\\w+)@(\\w+.\\w+)".r

  val valid = "jdoe@b.com"

  println(emailPattern matches valid)
  println(emailPattern matches "valid")
  val emailPattern(user, domain) = valid

  println(user)
}


object Email {

}
