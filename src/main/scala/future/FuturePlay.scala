package future

import java.util.concurrent.{Executors, TimeUnit}

import scala.concurrent.duration.Duration
import scala.concurrent.impl.ExecutionContextImpl
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}

class Beer
class Vodka

object FuturePlay extends App{

  def pourBeer() = {
    Thread.sleep(2000)
    new Beer()
  }
  def pourVodka() = {
    Thread.sleep(2000)
    new Vodka()
  }

  def measure[R](work: => R):R = {
    val t0 = System.currentTimeMillis()
    val r = work
    val t1 = System.currentTimeMillis()
    println("took " + (t1-t0) + " ms")
    r
  }

  measure {
    import ExecutorulComunist._
    val visLaBere = Future{pourBeer()}
    val visCuVodka = Future{pourVodka()}

    val beer = Await.result(visLaBere, Duration(1,TimeUnit.HOURS))
    val vodka = Await.result(visCuVodka, Duration(1,TimeUnit.HOURS))
    println(s"Disfruto $beer and $vodka")
  }

//  executor.shutdown()
}

object ExecutorulComunist {
  val executor = Executors.newFixedThreadPool(2)
  implicit val context: ExecutionContextExecutor = ExecutionContext.fromExecutor(executor)

}
