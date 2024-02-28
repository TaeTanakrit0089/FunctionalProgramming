package Module2.Recursion

object Factorial {
  def main(args: Array[String]): Unit = {
    println(factorial(100))
  }

  def factorial(num: Long): Long =
    if (num == 0) then 1 else factorial(num - 1) * num
}
