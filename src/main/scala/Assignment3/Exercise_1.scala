package Assignment3

import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File

case class Result(name: String, image: String, timestamp: String)

object Exercise_1 {
  def main(args: Array[String]): Unit = {
    // initialize the Jsoup-backed browser
    val browser = JsoupBrowser()
    // download the target page
    val doc = browser.get("https://www.it.kmitl.ac.th/~it65070089/works/Lobsters.html")

    // get the first HTML product on the page
    val htmlProductElements = doc >> elementList("div.byline")

    println(htmlProductElements >> element("img"))

    // transform the HTML product elements into a list
    // of Product instances
    val result: List[Result] = htmlProductElements.map(htmlProductElement => {
      // extract the desired data from it
      val name = (htmlProductElement >> element("img")).attr("alt")
      val image = (htmlProductElement >> element("img")).attr("src")
      val timestamp = htmlProductElement >> text("span")

      println(name + ", " + image + ", " + timestamp)
      // return a new Product instance
      Result(name, image, timestamp)
    })

    // create the output file
    val outputFile = new File("exercise1.csv")
    // initialize the CSV writer
    val writer = CSVWriter.open(outputFile)
    // transform the products in the format required by the
    // writer and populate the CSV output file
    writer.writeAll(result.map(result_member => List(result_member.name, result_member.image, result_member.timestamp)))
    // release the writer resources
    writer.close()
  }
}
