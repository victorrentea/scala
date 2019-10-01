package sfintesisoe

import sfintesisoe.DbError.InvalidSql

import scala.util.{Failure, Try}

object Exceptii extends App {

  val triedInt: Try[Int] = Try(1)



  private val value: Try[Nothing] = Failure(new Exception)
//  private val value: Try[Nothing] = Failure(DbError.InvalidSql)


  val err2: Try[InvalidSql] = Try(DbError.InvalidSql("SELECT FROM CCC"))
  val err3: Try[DbError.ConnectionLost.type] = Try(DbError.ConnectionLost)
  println(err2.isFailure)


  type Prost =String

  def cauta(iubirea:String, multi:Array[Prost]):Prost = {
    for (prost <- multi) {
      if (prost == "Fat Frumos")
        return prost
    }
    println("Beu Dansez, nu pot sa ma opresc")
    throw new IllegalStateException("Mai bine libera!")
  }

  def cauta2(iubirea:String, multi:Array[Prost]):Prost = {
    multi.map(prost => if (prost == "Fat Frumos") return prost)
    println("Beu Dansez, nu pot sa ma opresc")
    throw new IllegalStateException("Mai bine libera!")
  }

}


sealed trait DbError extends Product with Serializable
object DbError {
  case class InvalidSql(sql:String) extends DbError
  case object ConnectionLost extends DbError
}