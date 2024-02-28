package Module2.HandlingFailure

object Group {
  def main(args: Array[String]): Unit = {
    either(0.0, 0.0)
    println(divide_by_zero_try(50, 0))
    println(divide_by_zero_option(50, 0))
    println(divide_by_zero_option(50, 10))
    println(divide_by_zero_option(50, 7))
  }

  def divide_by_zero_ether(): Unit =
    println()

  enum a[+E, +A]: //สร้าง Either ที่ชื่อ a
    case L(i: E) // ค่าในฝั่ง L
    case R(t: A) // ค่าในฝั่ง R

  import a.{L, R}

  def either(x: Double, y: Double): Unit = // รับค่า x, y เป็น Double
    def check_either(num1: Double, num2: Double): a[String, Double] = //กำหนดให้ L return ค่าเป็น String , R return ค่าเป็น Double
      if (num2 == 0.0) L("Can't devide by zero") // ถ้า num2 เป็น 0.0 ใส่ ค่า String Can't devide by zero ไปที่ L
      else R(num1 / num2) // ให้ค่า num1 / num2 ใส่ที่ R


    check_either(x, y) match {
      case L(s) => println(s"Error: $s") // แสดงค่า L โดยที่แสดงแค่ผลลัพธ์ ใน L
      case R(t) => println(s"Result: $t") // แสดงค่า R โดยที่แสดงแค่ผลลัพธ์ ใน R
    }

  //  def divide_by_zero_try(num1: Int, num2: Int): String =
  //    try
  //      val result = num1 / num2
  //      result.toString
  //    catch
  //      case e: ArithmeticException => "Error!! : Can't divide by zero!!"

  def divide_by_zero_try(num1: Double, num2: Double): Unit =
    try {
      val result = num1 / num2
      if result.isInfinite then throw new ArithmeticException("Error : Can not devide by zero!")
      //หาก result = infinite จะทำการ throw "Error : Can not devide by zero!" ไปยัง catch
      else println(result)
      //หาก result ไม่ใช่ infinite หรือ num2 = 0 จะทำการปริ้นผลลัพธ์ที่ถูกต้องออกมา
    } catch {
      case e: ArithmeticException => println(e.getMessage)
      //ทำการ print message "Error : Can not devide by zero!" ทำกรณีของ result = infinity และ num2 = 0
    }

  def divide_by_zero_option(num1: Double, num2: Double): Option[Double] =
    // เช็คว่าตัวหารเป็น 0 หรือเปล่าถ้าเป็นก็ Return None
    if (num2 == 0) None
    // ถ้าไม่เป็น None ก็ return Some
    else Some(num1 / num2)
}


