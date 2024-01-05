@main
def main(): Unit = {
  val condition = true

  val result1 = if1(condition, () => 12, () => 456)
  val result2 = if2(condition, 13, "1324566")

  println(result1)
  println(result2)
}

def square(x: Double): Double = x * x

def if1[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A =
  if cond then onTrue() else onFalse()

def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
  if (cond) onTrue else onFalse