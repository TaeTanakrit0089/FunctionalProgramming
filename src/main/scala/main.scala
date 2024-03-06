type B[X] = X => X => X

@main
def main(): Unit = {

}

def ifThenElse[X](b: B[X], thenResult: X, elseResult: X): X =
  b(thenResult)(elseResult)

def and[X](a: B[B[X]], b: B[X]): B[X] = a(b)(FALSE)

def FALSE[X]: B[X] = a => b => b

def or[X](a: B[B[X]], b: B[X]): B[X] = a(TRUE)(b)

def TRUE[X]: B[X] = a => b => a

def not[X](a: B[B[X]]): B[X] = a(FALSE)(TRUE)