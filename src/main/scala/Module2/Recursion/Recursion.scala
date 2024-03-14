package Module2.Recursion

object Recursion {
  def main(args: Array[String]): Unit = {
    processCollectionThree(List(1, 4, 5, 7, 8))
  }

  def processCollection[A](collection: List[A]): Unit =
    while collection.nonEmpty do
      println(processOne(collection))

  def processCollectionTwo[A](collection: List[A]): Unit =
    var remaining = collection
    while remaining.nonEmpty do
      println(remaining)
      remaining = processOne(remaining)

  def processOne[A](collection: List[A]): List[A] =
    collection match
      case _ :: t => t
      case Nil => throw new Exception("EmptyList")

  def processCollectionThree[A](collection: List[A]): Unit =
    println(collection)
    if collection.nonEmpty then processCollectionThree(processOne(collection))

}
