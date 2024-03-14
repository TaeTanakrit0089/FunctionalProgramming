package Assignment3

import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File

class Student(val std_id: String, val participation: String, val score: String)

object Exercise_2 {
  def main(args: Array[String]): Unit = {
    val browser = JsoupBrowser()
    val doc = browser.get("https://www.it.kmitl.ac.th/~pattarachai/DiscreteMath/dm.htm")

    val htmlProductElements = doc >> elementList("tr")
    val data = htmlProductElements.drop(6)

    val student_result: List[Student] = data.map({ x =>
      val tdElements = x >> elementList("td")
      Student(tdElements.head.text, tdElements(1).text, tdElements(2).text)
    })

    val outputFile = new File("exercise2.csv")
    val writer = CSVWriter.open(outputFile)
    writer.writeAll(student_result.map(x => List(x.std_id, x.participation, x.score)))
    writer.close()
  }
}
