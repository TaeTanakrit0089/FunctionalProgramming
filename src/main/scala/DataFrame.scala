import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object DataFrame {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]")
      .appName("sparktest")
      .getOrCreate()

    import spark.implicits._
    val dataSeq = Seq(("Java", 20000), ("Python", 100000), ("Scala", 3000))
    val rdd4 = spark.sparkContext.parallelize(dataSeq)


    // Create DataFrame with custom column names
    val dfFromRDD = rdd4.toDF("language", "users_count")
    dfFromRDD.printSchema()
    dfFromRDD.show()

    //Read CSV file into dataframe
    val df = spark.read.option("header", value = true).csv("data/AAPL.csv")
    df.show()

    //add data sequence into dataframe
    val data = Seq(("Thai"," ","Thanawut","1991-04-01","M",3000),
      ("Jen","Mary","Brown","1980-02-17","F",4000)
    )
    val columns = Seq("firstname","middlename","lastname","dob","gender","salary")
    val df2 = spark.createDataFrame(data).toDF(columns:_*)
    df2.show()




    val rdd: RDD[Int] = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5))
    val rddCollect: Array[Int] = rdd.collect()
    println("Number of Partitions: " + rdd.getNumPartitions)
    println("Action: First element: " + rdd.first())
    println("Action: RDD converted to Array[Int] : ")
    rddCollect.foreach(println)
  }
}
