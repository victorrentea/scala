package ch8

object Closures extends App{

  var x = 1
  def f(): Int = {
    x
  }
  println(f())

  x = 2
  println(f())


  def acumulator(): () => Int = {
    var v = 1
    () => {
      v = v + 1
      v
    }
  }

  val a: () => Int = acumulator()
  println(a())
  println(a())
  println(a())
  println(a())



//  def getConfiguration():Config = {
//    var config: Config = null
//
//  }

  lazy
  val config = loadConfig()

  def loadConfig():Config = {
    println("Load config")
    Thread.sleep(4000)
    new Config(Math.random())
  }
  println("incepe app")

  println(config)
  println(config)

}

case class Config(double: Double)
