
object Solution {

  def main(args: Array[String]): Unit = {
    ???
  }  

  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    merge(intervals :+ newInterval)
  }

  private def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
      
      // assuming the pairs are ordered!!!!
      val pairs = intervals.map(x=> (x(0), x(1))).toList.sortBy(_._1)
      
      @annotation.tailrec
      def iter(acc: List[(Int, Int)], intervals: List[(Int, Int)], tupleOpt: Option[(Int, Int)]): List[(Int, Int)] = {

        (tupleOpt, intervals) match {
                    
          case (Some(tuple), h::t) =>
            if((tuple._1 <= h._1 && tuple._2 >= h._1 && tuple._2 <= h._2) ||
               (tuple._1 <= h._1 && tuple._2 >= h._1 && tuple._2 >= h._2))
              iter(acc, t, Some((tuple._1, math.max(tuple._2, h._2))))
            else iter(tuple :: acc, t, Some(h))
          
          case (None, h::t) =>
            iter(acc, t, Some(h))
          
          case (Some(tuple), Nil) =>
            tuple :: acc
          
          case (None, Nil) =>
            acc
        }
      }
      
      iter(List.empty, pairs, None).map(x => Array(x._1, x._2)).reverse.toArray
    }
}