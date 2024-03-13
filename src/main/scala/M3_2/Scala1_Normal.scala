package M3_2

import java.io.File

object Scala1_Normal extends App {
  val t1 = System.nanoTime
  val files = gather()
  val duration = (System.nanoTime - t1) / 1e9d
  for (file <- files) {
    val f = io.Source.fromFile(file)
    for (line <- f.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      if (cols(12) == "member") {
        println("member ride found")
      }
    }
    f.close
  }

  def gather(): List[java.io.File] = {
    val d = new File("trips")
    val files = d.listFiles.filter(_.isFile).toList.filter(_.getName.endsWith(".csv"))
    files
  }

  println(duration)
}
