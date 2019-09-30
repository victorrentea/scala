package ch26

object DinCarte extends  App{


  println(userTwiceUpper("ABAB@gaga.com"))
  println(userTwiceUpper("abab@gaga.com"))
  println(userTwiceUpper("ABA@gaga.com"))
  println(userTwiceUpper("ABAgaga.com"))


  def userTwiceUpper(s: String) = s match {
    case EMail(UpperCase(x @ Twice(_)), domain) =>
      "match: " + x + " in domain " + domain
    case _ =>
      "no match"
  }
}

object EMail {

  // The injection method (optional)
  def apply(user: String, domain: String) = user + "@" + domain

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s: String): Option[String] = if (s.toUpperCase == s) Some(s) else None
}

