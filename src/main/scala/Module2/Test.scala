package Module2

object Test {
  def main(args: Array[String]): Unit = {
    //    @tailrec
    //    def gcd(val1: Int, val2: Int): Int = {
    //      if val1 == val2 then val1
    //      else if val1 > val2 then gcd(val1 - val2, val2)
    //      else gcd(val1, val2 - val1)
    //    }
    //
    //    println(gcd(1, 10))
    def function1(path: String): Unit = {
      val source = scala.io.Source.fromFile(path)
      val lines = source.getLines().toList.map(_.toInt)
      println(lines)
      if lines.isEmpty then throw new Exception("The file is empty")
      lines.foreach(println)

      source.close()

    }

    function1("src/main/scala/Module2/number.txt")
  }
}
