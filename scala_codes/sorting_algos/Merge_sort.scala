package Scala_codes

object MergeSort{

  def main(args: Array[String]) {
    val A:Array[Int] = Array(0, 5, 2, 6, 3, 1)
    println("Input: " + A.toList)
    sort(A)
    println("Sorted: " + A.toList)
  }

  def sort(array:Array[Int]) {
    if (array.length > 1 ){
      val firstArrayLength = (array.length / 2)
      val first:Array[Int] = array.slice(0, firstArrayLength)
      val second:Array[Int] = array.slice(firstArrayLength, array.length)
      sort(first)
      sort(second)
      merge(array, first, second)
    }
  }

  def merge(result:Array[Int], first:Array[Int], second:Array[Int]) {
    var i:Int = 0
    var j:Int = 0
    for (k <- 0 until result.length) {
      if(i<first.length && j<second.length){
        if (first(i) < second(j)){
          result(k) = first(i)
          i=i+1
        } else {
          result(k) = second(j)
          j=j+1
        }
      }else if(i>=first.length && j<second.length){
        result(k) = second(j)
        j=j+1
      } else {
        result(k) = first(i)
        i=i+1
      }
    }
  }

}
