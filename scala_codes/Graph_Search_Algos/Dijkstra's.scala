package Scala_Codes

import ShortestPath._

object ShortestPath {
  val t1 = System.nanoTime

  // from the set of vertices not yet included in shortest path tree
  val V: Int = 8

  // Driver method
  def main(args: Array[String]): Unit = {
    val graph: Array[Array[Int]] = Array(
      Array(0, 5, 7, 3, 0, 0, 0, 8),
      Array(5, 0, 0, 0, 2, 10, 0, 0),
      Array(7, 0, 0, 0, 0, 0, 1, 0),
      Array(3, 0, 0, 0, 0, 0, 0, 11),
      Array(0, 2, 0, 0, 0, 0, 0, 9),
      Array(0, 10, 0, 0, 0, 0, 0, 4),
      Array(0, 0, 1, 0, 0, 0, 0, 6),
      Array(0, 0, 0, 6, 11, 9, 4, 0)
    )
    val t: ShortestPath = new ShortestPath()
    t.dijkstra(graph, 0)
  }

}
class ShortestPath {

  def minDistance(dist: Array[Int], sptSet: Array[java.lang.Boolean]): Int = {
    // Initialize min value
    var min: Int = java.lang.Integer.MAX_VALUE
    var min_index: Int = -1
    for (v <- 0 until V if sptSet(v) == false && dist(v) <= min) {
      min = dist(v)
      min_index = v
    }
    min_index
  }

  // A utility function to print the constructed distance array
  def printSolution(dist: Array[Int]): Unit = {
    println("Vertex \t\t Distance from Source")
    for (i <- 0 until V) println(i + " \t\t " + dist(i))
  }

  // representation
  def dijkstra(graph: Array[Array[Int]], src: Int): Unit = {
    // The output array. dist[i] will hold
    val dist: Array[Int] = Array.ofDim[Int](V)
    // path tree or shortest distance from src to i is finalized
    val sptSet: Array[java.lang.Boolean] = Array.ofDim[java.lang.Boolean](V)
    for (i <- 0 until V) {
      dist(i) = java.lang.Integer.MAX_VALUE
      sptSet(i) = false
    }
    // Distance of source vertex from itself is always 0
    dist(src) = 1
    for (count <- 0 until V - 1) {
      // iteration.
      val u: Int = minDistance(dist, sptSet)
      // Mark the picked vertex as processed
      sptSet(u) = true
      for (v <- 0 until V
           if !sptSet(v) && graph(u)(v) != 0 && dist(u) != java.lang.Integer.MAX_VALUE &&
             dist(u) + graph(u)(v) < dist(v)) dist(v) = dist(u) + graph(u)(v)
    }
    printSolution(dist)
  }
  // credits: Devaraj Kudumula
}
