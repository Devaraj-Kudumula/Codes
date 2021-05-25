package Scala_Codes

object InsertionSort {
  val A:Array[Int] = Array(0, 5, 2, 6, 3, 1)
  
  def main(args: Array[String]) {
    val arr = ls.toArray
    println("Input: " + A.toList)
    insertionSort(A)
    println("Sorted: " + A.toList)
  }
  
  def insertionSort(array:Array[Int]) {
    for (outer <- 1 until array.length) {
      var temp = array.apply(outer)
      var inner = outer - 1
      while (inner >= 0 && temp < array.apply(inner)) {
        array.update(inner + 1, array.apply(inner))
        inner -= 1
      }
      array.update(inner + 1, temp)
    }
  }
