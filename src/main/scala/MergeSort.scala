object MergeSort {

  def main(args: Array[String]): Unit = {
    println(mergeSort(List(1234, 565, 234, 5345, 31, 4, 25, 34, 53, 45, 4, 645, 6, 2, 34234, 235, 53, 45, 34, 5, 1)))
  }

  private def mergeSort(list: List[Int]): List[Int] = {
    val n = list.length / 2
    if (n == 0) list
    else {
      val (left, right) = list.splitAt(n)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  @scala.annotation.tailrec
  private def merge(seq1: List[Int], seq2: List[Int], accumulator: List[Int] = List()): List[Int] =
    (seq1, seq2) match {
      case (Nil, _) => accumulator ++ seq2
      case (_, Nil) => accumulator ++ seq1
      case (x :: xs, y :: ys) =>
        if (x < y) merge(xs, seq2, accumulator :+ x)
        else merge(seq1, ys, accumulator :+ y)
    }
}
