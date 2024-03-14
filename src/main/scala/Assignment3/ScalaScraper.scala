import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File

// define a custom class to store the elements to scrape
case class Product(name: String, url: String, image: String, price: String)


object ScalaScraper {
  def main(args: Array[String]): Unit = {
    // initialize the Jsoup-backed browser
    val browser = JsoupBrowser()
    // download the target page
    val doc = browser.get("https://scrapeme.live/shop/")

    // get the first HTML product on the page
    val htmlProductElements = doc >> elementList("li.product")

    // trasform the HTML product elements into a list
    // of Product instances
    val products: List[Product] = htmlProductElements.map(htmlProductElement => {
      // extract the desired data from it
      val name = htmlProductElement >> text("h2")
      val url = htmlProductElement >> element("a") >> attr("href")
      val image = htmlProductElement >> element("img") >> attr("src")
      val price = htmlProductElement >> text("span")

      // return a new Product instance
      Product(name, url, image, price)
    })

    // create the output file
    val outpuFile = new File("products2.csv")
    // initialize the CSV writer
    val writer = CSVWriter.open(outpuFile)
    // transform the products in the format required by the
    // writer and populate the CSV output file
    writer.writeAll(products.map(product => List(product.name, product.url, product.image, product.price)))
    // release the writer resources
    writer.close()
  }
}
