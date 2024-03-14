package Assignment3

import com.github.tototoshi.csv.*
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.*
import net.ruippeixotog.scalascraper.dsl.DSL.Extract.*

import java.io.File

class Student(val std_id: String, val participation: String, val score: String)

object Exercise_2 {
  def main(args: Array[String]): Unit =
    val browser = JsoupBrowser()
    val doc = browser.get("https://www.it.kmitl.ac.th/~pattarachai/DiscreteMath/dm.htm") // ดึง HTML มาจากเว็ป

    val htmlProductElements = doc >> elementList("tr") // เอามาเฉพาะ tr และเอามาทำเป็น list
    val data = htmlProductElements.drop(6) // ลบหัวเรื่องของตารางออก

    val student_result: List[Student] = data.map({ x =>
      val tdElements = x >> elementList("td") // เอา td ทุกตัวใน tr มาทำเป็น list
      Student(tdElements.head.text, tdElements(1).text, tdElements(2).text) // ในตารางมีอยู่ 3 คอลัมน์เลยแตกตามนี้
    })

    val outputFile = new File("exercise2.csv") // สร้างไฟล์ csv
    val writer = CSVWriter.open(outputFile)
    writer.writeAll(student_result.map(x => List(x.std_id, x.participation, x.score))) // แปลงให้เป็น list อีกรอบนึง
    writer.close()
}
