import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object sparkscala {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]")
      .appName("sparktest")
      .getOrCreate()

    // Read files from multiple directories into Single RDD
    val rdd2 = spark.sparkContext.textFile("data/text01.txt,data/text02.txt,data/text03.txt")
    rdd2.foreach(f => println(f))

    // Read from csv file into RDD
    val rddFromFile = spark.sparkContext.textFile("data/AAPL.csv")

    // Applying map() on Rdd to get array[string]
    val rdd3 = rddFromFile.map(f => {
      f.split(",")
    })

    // Read data from RDD using foreach
    rdd3.foreach(f => {
      println("Col1:" + f(0) + ",Col2:" + f(1))
    })


    val rdd: RDD[Int] = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5))
    val rddCollect: Array[Int] = rdd.collect()
    println("Number of Partitions: " + rdd.getNumPartitions)
    println("Action: First element: " + rdd.first())
    println("Action: RDD converted to Array[Int] : ")
    rddCollect.foreach(println)
  }
}
