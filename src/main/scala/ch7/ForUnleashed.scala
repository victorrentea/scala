package ch7

import java.io.File

import scala.collection.mutable.ListBuffer
import scala.io.Source

object ForUnleashed extends App {
  println(totScala("""C:\workspace\scala\src\main\scala\ch1intro"""))

  def totScala(path:String):String = {
    val files = new File(path).listFiles()
    val listBuffer = new ListBuffer[String]
    for (file <- files) {
      if (file.getName.endsWith(".scala")) {
        val lines = Source.fromFile(file).getLines()
        listBuffer ++= (for (line <- lines) yield line.toUpperCase)
      }
    }
    listBuffer.mkString("\n")
  }

}
