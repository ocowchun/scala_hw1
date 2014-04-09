package hw2

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def isEmpty: Boolean = true
  override def toString = "."
  def union(other: IntSet): IntSet = other
  def size: Int = 0
  def toArray: Array[Int] = {
    Array()
  }
}