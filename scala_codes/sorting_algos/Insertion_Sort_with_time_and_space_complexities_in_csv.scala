package Scala_codes

import util.Random
import java.io._

object InsertionSort {
  val A:Array[Int] = Array(0, 5, 2, 6, 3, 1)
  
  def main(args: Array[String]) {
    val end = 200000                                
    val begn = 1                                    
    val inc = 10000                                 
    val mess = (begn to end by inc).toArray        

    var fibTime: Array[Long] = Array()             
    var Mem: Array[Long] = Array()                  

    for (i <- mess) {
      var avgTime: Array[Long] = Array()
      var avgMem: Array[Long] = Array()
      for (_ <- 0 to 5) {
        val x = Array.fill(i)(10000).map(Random.nextInt)
        val t0 = System.nanoTime()
        insertionSort(x)
        val t1 = System.nanoTime() - t0
        avgTime = avgTime :+ t1
        val runtime = Runtime.getRuntime()
        runtime.gc()
        val s2 = runtime.totalMemory() - runtime.freeMemory()
        avgMem = avgMem :+ s2
      }
      fibTime = fibTime :+ (avgTime.reduce(_ + _) / avgTime.length)
      Mem = Mem :+ (avgMem.reduce(_ + _) / avgMem.length)
    }
    val time = fibTime
    val memory = Mem

    val file = new File("C:/Users/DEVA/Desktop/insertion11.csv")

    val bw = new BufferedWriter(new FileWriter(file))

    for (n <- 1 until time.length) {
      bw.write(mess(n).toString + "," + time(n).toString + "," + memory(n).toString + "\n")
    }
    bw.close()

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
