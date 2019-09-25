import org.scalatest.FunSuite

import scala.collection.mutable

class StackTest  extends FunSuite {

  println("New test instance")



  test("two") {

  }

  test("stack pops what was pushed") {
    val st = new mutable.Stack[Int]()
    st.push(1)
    assert(st.pop() == 1)
  }
}
