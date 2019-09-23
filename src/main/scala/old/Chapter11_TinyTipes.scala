package old

//class Dollar(val value:Float) // asta ar fi o sublclasa a lui AnyRef

class Dollar(val value:Float) extends AnyVal {
  override def toString: String = "$" + value

}

object Chapter11_TinyTipes extends App {

  def imprumuta(bani:Dollar) = {
    println("am imprumutat banii: " + bani)
  }
  imprumuta(new Dollar(10))

}
