package hw2

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def isEmpty: Boolean = false
  override def toString = "{" + left + elem + right + "}"

  def union(other: IntSet): IntSet = ((left union right) union other) incl elem

  def size: Int = {
    
    if(this.isEmpty){
      return 0
    }
    else if (this.left.isEmpty) {
     
      1+this.right.size
    }
    else{
      this.left.size+1+this.right.size
    }
  }
  
  def toArray:Array[Int]={
    if(this.isEmpty){
      return Array()
    }
    else if (this.left.isEmpty) {
    return  Array(elem).union(this.right.toArray)
    }
    else{
        return left.toArray.union(Array(elem)).union(this.right.toArray)
     // this.left.size+1+this.right.size
    }
  }
  
}
