package hw2

object result {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(49); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : hw2.NonEmpty = """ + $show(t1 ));$skip(42); 
  val t2 = new NonEmpty(4, t1, new Empty);System.out.println("""t2  : hw2.NonEmpty = """ + $show(t2 ));$skip(31); 

  val result1 = List(1, 2, 3);System.out.println("""result1  : hw2.List.List[Int] = """ + $show(result1 ));$skip(26); 

  val result2 = List(t2);System.out.println("""result2  : hw2.List.List[Int] = """ + $show(result2 ))}
}
