import java.io.File
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Scala2_Future extends App {
  val t1 = System.nanoTime
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  val files: Future[List[java.io.File]] = Future {
    val d = new File("trips")
    val files = d.listFiles.filter(_.isFile).toList.filter(_.getName.endsWith(".csv"))
    files
  }
  val duration = (System.nanoTime - t1) / 1e9d

  files.onComplete {
    case Success(files) => {
      for (f <- files) transform(f)
    }
    case Failure(exception) => println("Failed with: " + exception.getMessage)
  }

  def transform(file: java.io.File): Unit = {
    val f = io.Source.fromFile(file)
    for (line <- f.getLines) {
      val cols = line.split(",").map(_.trim)
      if (cols(12) == "member") {
        println("member ride found")
      }
    }
    f.close
  }

  println(duration)
  //  Thread.sleep(25000)
}