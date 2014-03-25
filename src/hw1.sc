object hw1 {
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
  }                                               //> reduce: (combine: (Int, Int) => Int)(Int => Int) => (Int => (Int => Int))
  reduce((a,b)=>a+b)(a=>a)(1)(5)                  //> res0: Int = 15
}