package Week04

@main
def main(): Unit = {
  println(AND(true, true))
}

val TRUE = (x: Any) => (y: Any) => x

def AND(x: => Boolean, y: => Boolean): Boolean =
  x match {
    case true => TRUE(y, false)
    case false => FALSE(y, false)
  }

def TRUE(x: => Boolean, y: => Boolean): Boolean = x
def FALSE(x: => Boolean, y: => Boolean): Boolean = y

def NOT(x: => Boolean): Boolean =
  x match {
    case true => TRUE(false, true)
    case false => FALSE(false, true)
  }


