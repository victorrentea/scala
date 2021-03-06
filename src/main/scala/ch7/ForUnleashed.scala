package ch7

import java.io.File

import scala.collection.mutable.ListBuffer
import scala.io.Source

object ForUnleashed extends App {
  println(totScala("""C:\workspace\scala\src\main\scala\ch1intro"""))

  def totScala(path:String):String = {
//    val listBuffer = for (file <- new File(path).listFiles() // .stream()
//                          if file.getName.endsWith(".scala"); //.filter()
//                          lines = fileLines(file); //.map()
//                          line <- lines //.flatMap
//         ) yield line.toUpperCase()
//    listBuffer.mkString("\n")
    new File(path).listFiles()
        .filter(_.getName.endsWith(".scala"))
        .flatMap(fileLines(_))
        .map(_.toUpperCase())
        .mkString("\n")

  }

  // pt Madalina
//  new File(path).listFiles()
//    .filter(f=> {
//      println(s"filter $f" )
//      f.getName.endsWith(".scala")
//    })
//    .filter(f=> {
//      println(s"filter2 $f" )
//      f.getName.endsWith(".scala")
//    })

  private def fileLines(file: File): List[String] = {
    Source.fromFile(file).getLines().toList
  }
}
