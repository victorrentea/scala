package old

object Chapter15_Option extends App {

  val map = Map("France"->"Paris", ("Romania", "Bucharest"))
  val orasulLuminii = map("France") //asta presupune ca tu bagi in cuptor ca e cheia acolo
  if (orasulLuminii != null) {
    println("e ceva acolo")
  }

  val unPinguin:Option[String] = map.get("Polul Nord")
  println("Cu ce m-am ales in viata: " + unPinguin)

  val optParisCaEScump = map.get("France")
  println("Lasa draga, mergem la anu:" + optParisCaEScump)

  val s:String =optParisCaEScump.getOrElse("Nimic")
  println("print: " + s)

  val ss:String = optParisCaEScump match {
    case Some(s) => s
    case None => "Nimic"
  }
  val f:Option[String] => String =  {
    case Some(s) => s
    case None => "Nimic"
  }
  val partial : PartialFunction[Option[String], String] = {
    case Some(s) => s
    case None => "Nimic"

  }
//  partial.isDefinedAt()
    println("print: " + ss)

  val secvDePerechi = Array((1,"one"),(2,"two"),(3,"three"))
  //"1-2-3" si "one-two-three"
  val (arrNumere, arrStringuri) = secvDePerechi.unzip // un fel de pattern matching la botu calului
  arrNumere.mkString("-")

  val input = "a@b.com basd asldsakjfdsag jsd victor@b.com asd sa"

  val Email = """(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])"""
      .r
  for (email <- Email findAllIn input) {
    println(email)
  }

  val Decimal = "(-)?(\\d+)(\\.\\d*)?".r


  val Decimal(sign, integerpart, decimalpart) = "1.23"
  println("semn: " + sign)
  println("intreg: " + integerpart)
  println("zecimal: " + decimalpart)




}
