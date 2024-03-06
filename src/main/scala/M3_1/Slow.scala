package M3_1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

object Slow {
  def main(args: Array[String]): Unit = {
    Print_one()
    Print_two()
  }

  def Print_one(): Unit = {
    println('A')
    Future(println('B'))
    println('C')
  }

  def Print_two(): Unit = {
    slowPrint('A')
    Future(slowPrint('B'))
    slowPrint('C')
  }

  def slowPrint(x: Any) = {
    var n = BigInt("100000000")
    while (n > 0) {
      n -= 1
    }
    println(x)
  }

  def calculate_d(input: Int): Future[Int] = Future {
    Thread.sleep(10000)
    input * input
  }

  def calculate_fp(input: Int): Promise[Int] = {
    val promise = Promise[Int]()
    Future {
      Thread.sleep(10000)
      promise.success(input * input)
    }
    promise
  }
}
