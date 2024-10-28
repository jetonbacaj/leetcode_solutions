import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.ArrayBuffer

object Solution {

    def main(args: Array[String]): Unit = {
        val medianFinder = new MedianFinder()


        medianFinder.addNum(-1)   
        println(medianFinder.findMedian()) 
        medianFinder.addNum(-2)   
        println(medianFinder.findMedian())
        medianFinder.addNum(-3)   
        println(medianFinder.findMedian())
        medianFinder.addNum(-4)   
        println(medianFinder.findMedian())
        medianFinder.addNum(-5)   
        println(medianFinder.findMedian())

        // medianFinder.addNum(1);    // arr = [1]
        // medianFinder.addNum(2);    // arr = [1, 2]
        // println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        // medianFinder.addNum(3);    // arr[1, 2, 3]
        // println(medianFinder.findMedian()); // return 2.0
    }

    class MedianFinder() {

        private val pq = new scala.collection.mutable.ArrayBuffer[Int]()
        
        def addNum(num: Int): Unit = pq.addOne(num)
        
        def findMedian(): Double = {
            pq.sortInPlace()
            val arraySize = pq.size

            if(arraySize == 1) 
                pq(0).doubleValue
             else if(arraySize % 2 == 0)
                (pq((arraySize-1)/2) + pq(arraySize/2)).doubleValue() / 2
                
            else
                pq(arraySize/2).doubleValue()
            
        }
    }
}