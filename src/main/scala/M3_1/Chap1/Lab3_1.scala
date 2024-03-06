package M3_1.Chap1

object Lab3_1 {
  def main(args: Array[String]): Unit = {

    num3()
  }

  def num3() = {
    println(os.list(os.pwd))
    println(os.walk(os.pwd))
    println(os.stat(os.pwd / "newer.txt"))
    println(os.isFile(os.pwd / "newer.txt"))
    println(os.mtime(os.pwd / "newer.txt"))
    println(os.size(os.pwd / "newer.txt"))
    println(os.isDir(os.pwd / "newer.txt"))
    println(os.isDir(os.pwd / "new-folder"))

  }


  def num2() = {
    //    println(os.write(os.pwd / "new.txt", "Hello"))
    //
    //    println(os.list(os.pwd))
    //
    //    println(os.read(os.pwd / "new.txt"))

    //    println(os.move(
    //      os.pwd / "new.txt",
    //      os.pwd / "newer.txt"
    //    ))
    //
    //    println(os.list(os.pwd))

    //    println(os.copy(
    //      os.pwd / "newer.txt",
    //      os.pwd / "newer-2.txt"
    //    ))

    //    println(os.remove(os.pwd / "newer.txt"))
    //    println(os.makeDir(os.pwd / "new-folder"))

    println(os.walk(os.pwd).filter(os.isFile).map(p => (os.size(p), p)).sortBy(-_._1).take(5))

    println(os.list(os.pwd))


  }

  def num1(): Unit = {
    println(os.pwd)
    println(os.root)
    println(os.home)
    println(os.home.segments.toList)
    println(os.home.last)
    println(os.home / "Github" / "blog")
    //    println(os.home / "Github/blog")
    println(os.pwd / os.up)
    println(os.pwd / os.up / os.up)
    println(os.Path("/Users/tae"))

    val helloRelPath = os.RelPath("../hello")
    println(os.home / helloRelPath)
  }
}