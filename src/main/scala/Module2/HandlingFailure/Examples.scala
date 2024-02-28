package Module2.HandlingFailure

object Examples {
  def main(args: Array[String]): Unit = {
    //    println(makeInt("10"))
    println(StringToInt("25"))
  }

  def makeInt(s: String): Int =
    try
      s.toInt
    catch
      case e: NumberFormatException => 0
    finally
      println("finally!")

  enum Option[+A]:
    case Some(get: A)
    case None

  import Option.{None, Some}

  def StringToInt(s: String): Option[Int] =
    try
      Some(s.toInt)
    catch case e: NumberFormatException => None

  def CallMakeInt(aString: String): Unit =
    StringToInt(aString) match
      case Some(i) => println(s"Conversion worked. i = $i")
      case None => println("The conversion failed.")


}
