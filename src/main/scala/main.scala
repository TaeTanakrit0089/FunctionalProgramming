@main
def main(): Unit = {

}

type B[X] = X => X => X
def TRUE[X]: B[X] = a => b => a
def FALSE[X]: B[X] = a => b => b
def ifThenElse[X](b: B[X], thenResult: X, elseResult: X): X =
  b(thenResult)(elseResult)

def and[X](a: B[B[X]], b: B[X]): B[X] = a(b)(FALSE)
def or[X](a: B[B[X]], b: B[X]): B[X] = a(TRUE)(b)
def not[X](a: B[B[X]]): B[X] = a(FALSE)(TRUE)