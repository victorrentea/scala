package ch15

object OptionPlay extends App {

  val capitale = Map("Islanda"->"Reiyjkavik", "France"->"Paris")

  println(capitale("France")) // bagi mana in foc ca exista cheia
  // println(capitale("Brexit")) // bubuie cu exceptie la runtime JDD

  val londraSper = capitale.get("Brexit")
  println(londraSper.getOrElse("Fara nume").toUpperCase())

  def m1(optString : Option[String]): String = {
    if (optString.isDefined) { // java -style
      optString.get + " Permanent"
    } else {
      "Absenta"
    }
  }


  def m2(optString : Option[String]): String = {
    optString match { // gandam-style
          case Some(veverita) => veverita + " Permanent"
          case None => "Absenta"
        }
  }
  println(m1(londraSper))
  println(m1(capitale.get("Islanda")))

  londraSper.foreach(println(_)) // ~ Optional<String>.ifPresent(v -> )
  println(londraSper.isDefined) // ~ isPresent
//  londraSper.



}
