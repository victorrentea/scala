package ch15

class Enumerari {

}

abstract class OrderStatus private (val code:String) {
  def methodaDupaStatus: Int
}
// nu ai voie sa mai definesti vreun subtip al asteia in alt fisier
object OrderStatus {
  case object DRAFT extends OrderStatus("a") {
    override def methodaDupaStatus: Int = 1
  }
  case object ACTIVE extends OrderStatus("b") {
    override def methodaDupaStatus: Int = 2
  }
  case object INCAUNA extends OrderStatus("c") {
    override def methodaDupaStatus: Int = 2
  }
}

class Order {
  private var status: OrderStatus = OrderStatus.DRAFT

  def getStatus: OrderStatus = status
  def activate(): Unit = {
    status = OrderStatus.ACTIVE
  }
}

class Bizniss {
  def process(order: Order): Int = {
    order.getStatus match {
      case OrderStatus.DRAFT => throw new IllegalStateException()
      case OrderStatus.ACTIVE => 1
    }
  }
}
