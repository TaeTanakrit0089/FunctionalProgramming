package Lazy

@main
def main(): Unit = {
  println(lazyNot(true))

  val lazyList = LazyList(1, 2, 3, 4, 5, 6).map { x =>
    println(s"Mapping $x")
    x * 2
  }

  val listView = List(1, 2, 3, 4, 5, 6).view.map { x =>
    println(s"Mapping $x")
    x * 2
  }

  println(lazyList.take(3).toList)
  println(listView.take(3).toList)
}


def lazyAnd(condi1: => Boolean, condi2: => Boolean): Boolean =
  if (condi1) condi2 else false

def lazyOr(condi1: => Boolean, condi2: => Boolean): Boolean =
  if (condi1) true else condi2

def lazyNot(condi1: => Boolean): Boolean =
  if (condi1) false else true




