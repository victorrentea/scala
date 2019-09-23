package ch1intro

import scala.io.Source

object FilePlay extends App {
  val lines = Source.fromFile("build.sbt").getLines().toList

  // TODO print lines with length before
}
