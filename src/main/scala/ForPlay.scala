import java.io.File

import scala.io.Source

object ForPlay extends App {
  val currentDir = new File("""src\main\scala""");

  def fileLines(f:File):Seq[String] = Source.fromFile(f).getLines().toSeq

  for (file <- currentDir.listFiles) {
    println(file.getName)
  }
  for (i <- 0 until currentDir.listFiles.length) {
    println(currentDir.listFiles()(i).getName)
  }
  val names =
    for (file <- currentDir.listFiles;
        if file.isFile;
         line <- fileLines(file);
          lineLength = line.size
         ) yield lineLength

  println(names.mkString(" "))
}
