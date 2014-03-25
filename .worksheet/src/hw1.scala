object hw1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(408); 
   def reduce(combine:(Int, Int) => Int): (Int=>Int) => (Int) => (Int) => Int = {
    def func(f: Int => Int): (Int) => (Int) => Int = {
      def from(start: Int): (Int) => Int = {
        def to(end: Int): Int = {
          if (start==end)
          f(start)
          else
          combine(f(start),reduce(combine)(f)(start+1)(end))
        }
        to
      }
      from
    }
    func
  };System.out.println("""reduce: (combine: (Int, Int) => Int)(Int => Int) => (Int => (Int => Int))""");$skip(33); val res$0 = 
  reduce((a,b)=>a+b)(a=>a)(1)(5);System.out.println("""res0: Int = """ + $show(res$0))}
}
