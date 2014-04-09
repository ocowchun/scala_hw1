package hw2

object List {
  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }
  

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil head")
    def tail = throw new NoSuchElementException("Nil tail")
  }

  def reduce[T](numbers: Array[T]): List[T] = {
    val length = numbers.length
    if (numbers.length == 0) {
      new Nil
    } else {
      new Cons(numbers(0), reduce(numbers.slice(1, length)))
    }
  }
  def apply(set1: IntSet) = reduce(set1.toArray)
  def apply[T:ClassManifest] (numbers: T*)={
     val ary = new Array[T](numbers.length)
    for (i <- 0 until numbers.length) {
    val elem=numbers(i)
      ary.update(i,elem)
    }
    reduce(ary)
  }
}