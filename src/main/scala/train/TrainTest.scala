package train

import train.Types.{AllTrainData, SeatInfo}

object TrainTest extends App{

  val data = Map(
    "express" -> List(
      "1A"->("", "1","A"), //liber
      "2A"->("1231231", "2","A"), // rezervat deja
         // vag A al acestui tren pare ca are doar 2 locuri
      "1B"->("", "1","B"),
    )
  )
  def seat(seatId:Int, coachId:String, free:Boolean):SeatInfo =
    (coachId+seatId) -> (if (free) "" else "bookref", seatId.toString, coachId)
  def coach(coachId:String, procentFree10:Int, totalSeats:Int=10): List[SeatInfo] =
    (1 to totalSeats).map(i => seat(i, coachId, i<=procentFree10*10/totalSeats)).toList
  def train(trainId: String, seats : List[SeatInfo]*) =
    Map(trainId -> seats.flatten.toList)

  val d = train("express",
    coach("A",5, 2),
    coach("B", 3)
  )
//  println(coach("A", 2).mkString("\n"))
  println(d("express").mkString("\n"))

  val toTest = configure(data)
      .reserve(ReservationRequest("express",1))

  // depasesti total tren
  require(configure(train("tren",
    coach("A", 8)))
    .reserve(ReservationRequest("tren", 1)).isEmpty)

  // gresesti id tren
  require(configure(train("tren",
    coach("A", 2)))
    .reserve(ReservationRequest("trenXX", 1)).isEmpty)

  // OK
  require(configure(train("tren",
    coach("A", 2)))
    .reserve(ReservationRequest("tren", 1)) match {
    case Some(ReservationResponse("tren",ref, List("A1"))) => true
  })

  // OK
  require(configure(train("tren",
    coach("A", 8),
    coach("B", 2)))
    .reserve(ReservationRequest("tren", 2)) match {
    case Some(ReservationResponse("tren",ref, List("B1","B2"))) => true
  })

  private def configure(data:Types.AllTrainData): RenameMe with ReservationService = {
    new RenameMe() with ReservationService {
      override def getAllTrainData: Types.AllTrainData = data
    }
  }
}
case class ReservationRequest(trainId: String, count: Int)
case class ReservationResponse(trainId: String, bookingReference: String, seats:List[Types.SeatId])
object Types {
  type SeatId = String //eg 1A
  type SeatInfo = (SeatId,(/*bookref*/String, /*number*/String,/*coach*/String))
  type TrainId = String
  type AllTrainData = Map[TrainId, List[SeatInfo]]
}

trait ReservationService {

  //call this function at initialization, store data you get in a variable, then handle calls to second method
  def getAllTrainData: Types.AllTrainData = Map()

  // va fi chemata de mai multe ori sucesiv, pentru mai multe requesturi
  def reserve(request:ReservationRequest): Option[ReservationResponse]
}

//trait FakeDataProvider extends

class RenameMe extends ReservationService {
  var data = getAllTrainData

  override def reserve(request: ReservationRequest): Option[ReservationResponse] = {
    //TODO
    throw new NotImplementedError()
  }
}