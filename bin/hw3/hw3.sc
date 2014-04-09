package hw3

object hw3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Product(e1: Expr, e2: Expr) extends Expr
  case class Var(n: String) extends Expr

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(Product(a, b), Product(c, d)) => {
      //eval(e2) + eval(e2)
      if (eval(a) == eval(c)) // || eval(a) == eval(d))
        eval(Product(a, Sum(b, d)))
      else if (eval(a) == eval(d))
        eval(Product(a, Sum(b, c)))
      else if (eval(b) == eval(c))
        eval(Product(b, Sum(a, d)))
      else if (eval(b) == eval(d))
        eval(Product(b, Sum(a, c)))
      else {
        eval(Product(a, b)) + eval(Product(c, d))
      }

    }

    case Sum(e1, e2) => eval(e1) + eval(e2)

  }                                               //> eval: (e: hw3.hw3.Expr)Int

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(Product(a, b), Product(c, d)) => {
      if (eval(a) == eval(c))
        show(Product(a, Sum(b, d)))
      else if (eval(a) == eval(d))
        show(Product(a, Sum(b, c)))
      else if (eval(b) == eval(c))
        show(Product(b, Sum(a, d)))
      else if (eval(b) == eval(d))
        show(Product(b, Sum(a, c)))
      else {
        show(Product(a, b)) + "+" + show(Product(c, d))
      }

    }
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
    case Var(n) => n
    case Product(e1, e2) => {
      show2(e1) + "*" + show2(e2)
    }

  }                                               //> show: (e: hw3.hw3.Expr)String

  def show2(e3: Expr): String = e3 match {
    case Number(n) => n.toString
    case Sum(e1, e2) => "("+show(e3)+")"
    case Var(n) => show(e3)
    case Product(e1, e2) => show(e1) + "*" + show(e2)
  }                                               //> show2: (e3: hw3.hw3.Expr)String

  val expr1 = Product(Number(5), Number(3))       //> expr1  : hw3.hw3.Product = Product(Number(5),Number(3))
  val expr2 = Product(Number(7), Number(3))       //> expr2  : hw3.hw3.Product = Product(Number(7),Number(3))
  val expr3 = Sum(expr1, expr2)                   //> expr3  : hw3.hw3.Sum = Sum(Product(Number(5),Number(3)),Product(Number(7),N
                                                  //| umber(3)))
  val expr4=Product(Number(5),Number(2))          //> expr4  : hw3.hw3.Product = Product(Number(5),Number(2))
  val expr5=Product(expr3,expr4)                  //> expr5  : hw3.hw3.Product = Product(Sum(Product(Number(5),Number(3)),Product
                                                  //| (Number(7),Number(3))),Product(Number(5),Number(2)))
  show(expr3)                                     //> res0: String = 3*(5+7)
  show(expr5)                                     //> res1: String = (3*(5+7))*5*2

}