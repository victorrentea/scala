package old

trait Entity[ID] {
  def id: ID
}
trait JpaRepo[E<:Entity[ID],ID] {
  def getById(id:ID):E
  def remove(id:ID)
}
class Employee(var id:Long) extends Entity[Long] {

}
trait EmployeeRepo extends JpaRepo[Employee, Long]

object SpringDataJpaRepositoryPlay extends App {
  new Employee(1)

  val x = List(1)
}


