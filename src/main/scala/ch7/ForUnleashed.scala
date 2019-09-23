package ch7

import java.io.File

import scala.collection.mutable.ListBuffer
import scala.io.Source

object ForUnleashed extends App {
  println(totScala("""C:\workspace\scala\src\main\scala\ch1intro"""))

  def totScala(path:String):String = {
    val files = new File(path).listFiles()
    val listBuffer = new ListBuffer[String]
    for (file <- files // .stream()
         if file.getName.endsWith(".scala"); //.filter()
         lines = Source.fromFile(file).getLines(); //.map()
         line <- lines //.flatMap
         ) {
        listBuffer += line.toUpperCase
    }
    listBuffer.mkString("\n")
  }

}
