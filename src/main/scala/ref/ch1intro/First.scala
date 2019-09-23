package ref.ch1intro

object First extends App {
  println("Halo")

  args.foreach(println(_))
  for (a <- args) print(s"$a ")

  def sum(x: Int, y: Int): Int = {
    println("Halo2")
    x + y
  }

  println(sum(1, 2))

  def max(x: Int, y: Int): Int = if (x > y) x else y

}
