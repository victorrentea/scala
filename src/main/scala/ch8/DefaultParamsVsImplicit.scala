package ch8

object DefaultParamsVsImplicit extends  App{
  implicit val currentUserName = 12
  fCuDefaults("a")(11)
  fCuImplicit("a")

  def fCuDefaults(s:String)(arg:Int=10): Unit = {
    println(s + arg)
  }
  def fCuImplicit(s:String)(implicit arg:Int): Unit = {
    println(s + arg)
  }
}
