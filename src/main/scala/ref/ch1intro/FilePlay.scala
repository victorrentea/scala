package ref.ch1intro

import scala.io.Source

object FilePlay extends App {
  val lines = Source.fromFile("build.sbt").getLines().toList

  def widthOfLength(s:String):Int = s.length.toString.length
  val maxWidth = lines.map(widthOfLength).max


  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }

}
