package hw2

object result {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : hw2.NonEmpty = {.3.}
  val t2 = new NonEmpty(4, t1, new Empty)         //> t2  : hw2.NonEmpty = {{.3.}4.}

  val result1 = List(1, "2", 3)                   //> result1  : hw2.List.List[Any] = {1,{2,{3,{}}}}
val result2 = List(t2)                            //> result2  : hw2.List.List[Int] = {3,{4,{}}}
}