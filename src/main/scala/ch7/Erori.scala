package ch7

import java.io.IOException

object Erori extends  App{

  m()

  def m(): Unit = {
    try {
      altaProasta(-1);
    } catch {
      case e:IOException => println("Shaorma: " + e)
      case e:Exception => println("Cartofi prajiti: " + e)
      case _ => println("Duc gunoiul ca altceva nu merit in viata")
    }
  }
  def altaProasta(i:Int): Unit  = {
    if (i<0) throw new IOException("Ntz")
    if (i>0) throw new Exception("Ntz")
    if (i==0) throw new OutOfMemoryError();
  }
}
