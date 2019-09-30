package ch26

import scala.util.matching.Regex

object Extractor extends App {
  val EmailPattern: Regex = "(\\w+)@(\\w+.\\w+)".r

  val validEmail = "jdoe@b.com"

  println(EmailPattern matches validEmail)
  println(EmailPattern matches "valid")
  val EmailPattern(userX, domainX) = validEmail

  println(userX)

  val text = "Ana are emailul ana@maria.ro si vlad are vlad@tepes.ro"

  for (EmailPattern(user,domain) <- EmailPattern findAllIn text) {
    println(user)
  }
}


object Email {
  def unapply(emailString: String): Option[(String, String)] =
    if (emailString.contains("@")) {
      val arr = emailString.split("@")
      Some(arr(0), arr(1))
    } else None
}
