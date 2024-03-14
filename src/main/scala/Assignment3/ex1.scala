import org.jsoup.Jsoup

import scala.collection.JavaConverters.*

@main def hello(): Unit =
//  val doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get()
  val doc = Jsoup.parse(os.read(os.pwd / "Lobsters.html"))
//  println(os.pwd)
  //val doc = Jsoup.connect("https://developer.mozilla.org/en-US/docs/web/api").get()
  println(doc.title)

  val headline = doc.select("#mp-itn b a").asScala
  println(headline)
  val links = doc.select("h2#specifications").nextAll.select("div.index a").asScala
  val linkData = links.map(l => (l.attr("href"), l.attr("title"), l.text))
  println(linkData)
  for (h <- headline) yield println(h.text)
  for (h <- headline) yield println(h.attr("href"))
//for (h <- headline) yield println(h.attr("title"))
