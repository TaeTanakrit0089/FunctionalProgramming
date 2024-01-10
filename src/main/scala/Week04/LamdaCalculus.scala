package Week04

@main
def main(): Unit = {
  type Bool = (Boolean => Boolean => Boolean)
  val OR: (Bool) = x => y => if (x) true else y
  val AND: (Bool) = x => y => if (x) y else false
  val NOT: (Boolean => Boolean) = x => if (x) false else true
  println(AND(true)(false))
}
