package hw2

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def isEmpty: Boolean
  def union(other: IntSet): IntSet
  def size: Int
  def toArray:Array[Int]
}

class Person(name: String) {

  def hello(): String = name + " say hello"

  def say(txt: String, p: Person): String = {
    p hello ()
  }
}