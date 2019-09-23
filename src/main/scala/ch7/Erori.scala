package ch7

import java.io.IOException
import java.sql.SQLException

object Erori extends  App{

  println(m())

  def m(): Int = {
    try {
      altaProasta(0)
      1
    } catch {
      case e @ (_:IOException|_:SQLException) =>
        println("Shaorma: " + e)
        -1
      case e:Exception => println("Cartofi prajiti: " + e)
        -1
      case _ => println("Duc gunoiul ca altceva nu merit in viata")
        -1
    } finally {
      return 2 // puscarie
    }
  }
  def altaProasta(i:Int): Unit  = {
    if (i<0) throw new IOException("Ntz")
    if (i>0) throw new Exception("Ntz")
//    if (i==0) throw new OutOfMemoryError();
  }
}
