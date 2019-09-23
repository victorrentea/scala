package old

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x:Int): Unit
}

class BasicIntQueue extends IntQueue {

  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x
}

trait DoublingQueue extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x*2)
}
trait PositiveQueue extends IntQueue {
  abstract override def put(x: Int): Unit = if (x>0) super.put(x)
}
trait IncrementingQueue extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

//class CreepyQueue extends BasicIntQueue with IncrementingQueue with DoublingQueue

object Chapter12_Traits_StackableModifications extends App {
  // Mic indrumar de alegere Trait vs Abstract Class
  // - Daca vrei doar sa declari doar cateva metode (vrei de fapt o interface din Java) --> Trait
  // - Daca te astept ca ce scrii in acea clasa sa fie util de "amestecat" in diverse clase --> Trait (a se vedea Ordered. sau DoublingQueue)
  // - Daca te clasa ta reprezinta un concept de bussiness cu diverse subtipuri --> clasa abstracta

  // Abstract classes are fully interoperable with Java. You can call them from Java code without any wrappers. Traits are fully interoperable only if they do not contain any implementation code
  // In plus, din carte:
  // https://stackoverflow.com/questions/1991042/what-is-the-advantage-of-using-abstract-classes-instead-of-traits

//  val q:IntQueue = new CreepyQueue
  val q:IntQueue = new BasicIntQueue with IncrementingQueue with DoublingQueue
  q.put(1)
  q.put(2)
  q.put(3)
  println(q.get())
  println(q.get())
//  println(q.get())
}
