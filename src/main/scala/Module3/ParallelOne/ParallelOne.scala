package Module3.ParallelOne

object ParallelOne {
  def main(args: Array[String]): Unit = {
    val lastNames = List("Smith", "Jones", "Frankenstein", "Bach", "Jackson", "Rodin").par
    println(lastNames.map(_.toUpperCase()))

  }
}
