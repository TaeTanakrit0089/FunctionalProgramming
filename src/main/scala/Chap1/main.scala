package Chap1

import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.mutable._

object main {
  def main(args: Array[String]): Unit = {
    sideEffect2()

  }

  def sideEffect2(): Unit = {
    val strings = List("abc","def","ghi","jk","lmnop","qrs","tuv","wx","yz").par
    println(strings)

    val alphabet = strings.reduce(_+_)
    println(alphabet)

  }

  def sideEffect(): Unit = {
    var sum = 0
    val list = (1 to 1000).toList.par
    list.foreach(sum += _)
    println(sum)
    sum = 0
    list.foreach(sum += _)
    println(sum)
    sum = 0
    list.foreach(sum += _)
    println(sum)


  }

  def parRange(): Unit = {
    println((1 to 3).par)
    println((15 to 5 by -2).par)
  }

  def pa(): Unit = {
    val pa = ParArray.tabulate(1000)(x => 2 * x + 1)

    println(pa.reduce(_ + _))

    println(pa.map(x => (x - 1) / 2))
  }

  def pv(): Unit = {
    var pv = new ParVector[Int]
    pv = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9).par
    println(pv)

    val pv2 = scala.collection.parallel.immutable.ParVector.tabulate(1000)(x => x)

    println(pv2.filter(_ % 2 == 0))


  }
}