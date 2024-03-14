package Assignment3

import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File

case class Product(name: String, url: String, image: String, price: String)

object Exercise_1 {
  def main(args: Array[String]): Unit = {
    // initialize the Jsoup-backed browser
    val browser = JsoupBrowser()
    // download the target page
    val doc = browser.get("https://www.it.kmitl.ac.th/~it65070089/Lobsters.html")

    // get the first HTML product on the page
    val htmlProductElements = doc >> elementList("li.product")

    // transform the HTML product elements into a list
    // of Product instances
    val products: List[Product] = htmlProductElements.map(htmlProductElement => {
      // extract the desired data from it
      val name = htmlProductElement >> text("h2")
      val url = (htmlProductElement >> element("a")).attr("href")
      val image = (htmlProductElement >> element("img")).attr("src")
      val price = htmlProductElement >> text("span")

      // return a new Product instance
      Product(name, url, image, price)
    })

    // create the output file
    val outputFile = new File("exercise1.csv")
    // initialize the CSV writer
    val writer = CSVWriter.open(outputFile)
    // transform the products in the format required by the
    // writer and populate the CSV output file
    writer.writeAll(products.map(product => List(product.name, product.url, product.image, product.price)))
    // release the writer resources
    writer.close()
  }
}
