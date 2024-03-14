package Assignment3

import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File
import scala.annotation.tailrec

class Student(val std_id: String, val participation: String, val score: String)


object Exercise_2 {
  @tailrec
  private def removeHeadElements[A](list: List[A], n: Int): List[A] =
    if (n <= 0) then list
    else list match
      case Nil => Nil // If the list is empty, return an empty list
      case _ :: tail => removeHeadElements(tail, n - 1) // Recursively call removeHeadElements with the tail of the list and decrement n

  def main(args: Array[String]): Unit = {
    // initialize the Jsoup-backed browser
    val browser = JsoupBrowser()
    // download the target page
    val doc = browser.get("https://www.it.kmitl.ac.th/~pattarachai/DiscreteMath/dm.htm")

    // get the first HTML product on the page
    val htmlProductElements = doc >> elementList("tr")
    val data = htmlProductElements.drop(6)


    val student_result: List[Student] = data.map({ x =>
      val tdElements = x >> elementList("td")
      Student(tdElements.head.text, tdElements(1).text, tdElements(2).text)
    })

    // create the output file
    val outputFile = new File("exercise2.csv")
    val writer = CSVWriter.open(outputFile)
    writer.writeAll(student_result.map(x => List(x.std_id, x.participation, x.score)))
    writer.close()
  }
}
