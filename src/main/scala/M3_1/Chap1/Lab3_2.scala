package M3_1.Chap1

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

    println(output(0))
    println(output(0)("hello"))

    val small = ujson.Arr(
      ujson.Obj("hello" -> "world", "answer" -> 42),
      true
    )
    println(small)
    small(0)("hello") = "goodbye"
    println(small)

    small(0)("tags") = ujson.Arr("awesome", "yay", "wonderful")

    println(small)
    small(0).obj.remove("hello")
    small.arr.append(123)

    println(small)

    def traverse(v: ujson.Value): Iterable[String] = v match {
      case a: ujson.Arr => a.arr.map(traverse).flatten
      case o: ujson.Obj => o.obj.values.map(traverse).flatten
      case s: ujson.Str => Seq(s.str)
      case _ => Nil
    }

//    println(traverse(small))
//    println(traverse(output))
    println(traverse(data))


  }
}
