object Lab3_2 {
  def main(args: Array[String]): Unit = {
    number1()
  }

  def number1() = {
    val output = ujson.Arr(
      ujson.Obj("hello" -> "world", "answer" -> 42),
      true
    )
    println(output)
    output(0)("hello") = "goodbye"
    println(output)
    output(0)("tags") = ujson.Arr("awesome", "yay", "wonderful")
    println(output)


    val jsonString = os.read(os.pwd / "full.json")
    val data = ujson.read(jsonString)
    println(data(0)("id"))
  }
}
