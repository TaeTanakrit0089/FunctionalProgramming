package Module2.Recursion

object TowerOfHanoi {
  def main(args: Array[String]): Unit = {
    hanoi(3, 'L', 'M', 'R')
  }

  def hanoi[A](n: Int, from: A, middle: A, to: A): Unit =
    if n > 0 then
      hanoi(n - 1, from, to, middle)
      println(s"$from -> $to")
      hanoi(n - 1, middle, from, to)
}
