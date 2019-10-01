//package train
//
//import scala.util.Random
//
//case class Train(id:String, coaches:List[Coach]) {
//
//  def canAllocate(n:Int):Boolean = {
////    if (totalOcupate + n / total >= 70)
//  }
//  def allocate(n:Int): List[String] = {
//    // am gasit vagonu
//    val c : Coach = null
//    val ids = c.seatsToAllocate(n)
//
//    val newC = c.allocate(ids)
//  }
//}
//case class Coach(id:String, totalSeats:List[Seat]) {
////  def
//  def allocate(seatIds:Seq[String]): Coach = {
//    val toAllocate = totalSeats.filter(seat => seatIds.contains(seat.id))
//    val newTotalSeats = totalSeats.diff(toAllocate) ::: toAllocate.map(_.occupy)
//    Coach(id, newTotalSeats)
//  }
//  def seatsToAllocate(n: Int): Seq[String] = totalSeats.filter(_.isFree).take(n).map(_.id)
//}
//
//class Seat(val id:String, var reservationId:String) {
//  val r = new Random()
//  def isFree: Boolean = reservationId == ""
//  def isOccupied: Boolean = !isFree
//  def occupy = new Seat(id, r.nextString(6))
//}