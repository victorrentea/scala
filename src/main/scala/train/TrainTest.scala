package train

object TrainTest {

  val data = Map(
    "express" -> List(
      "1A"->("", "1","A"),
      "2A"->("1231231", "2","A"), // rezervat deja
      "1B"->("", "1","B"),
    )
  )
  val toTest = configure(data)
      .reserve(ReservationRequest("express",1))

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