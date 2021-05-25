package Scala_codes

import java.io._
import util.Random

object InsertionSort {
  def main(args: Array[String]) {
    val p = scala.util.Random
    val ls = Random.shuffle((for (i <- 1 to 10) yield p.nextInt(100)).toList)
    val arr = ls.toArray
    println("Input: " + arr.toList)
    insertionSort(arr)
    println("Sorted: " + arr.toList)
  }
  def insertionSort(array:Array[Int]) {
    //first element is considered as sorted sublist
    for (outer <- 1 until array.length) {

      var temp = array.apply(outer)
      var inner = outer - 1
      // temp < array.apply(inner) is used for Ascending sort
      while (inner >= 0 && temp < array.apply(inner)) {

        array.update(inner + 1, array.apply(inner))

        inner -= 1

      }

      array.update(inner + 1, temp)

    }

  }
