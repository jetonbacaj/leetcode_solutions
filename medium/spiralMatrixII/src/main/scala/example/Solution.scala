
object Solution {
  def main(args: Array[String]): Unit = {
    // val result = generateMatrix(3) //[[1,2,3],[8,9,4],[7,6,5]]
    val result = generateMatrix(20) //[[1,2,3],[8,9,4],[7,6,5]]
    // val result = generateMatrix(1) //[[1,2,3],[8,9,4],[7,6,5]]
    // println(s"result = $result")
  }  

  def generateMatrix(n: Int): Array[Array[Int]] = {
    val numberOfElements = n * n

    sealed trait Direction
    case object RIGHT extends Direction
    case object DOWN extends Direction
    case object LEFT extends Direction
    case object UP extends Direction

    val array = Array.ofDim[Int](n, n)

    def canMove(seenTuples: Set[(Int, Int)], heightIndex: Int, widthIndex: Int): Boolean = 
       widthIndex > -1 && 
       widthIndex < n && 
       heightIndex > -1 && 
       heightIndex < n && 
       !seenTuples.contains((heightIndex, widthIndex))

    @annotation.tailrec
    def iter(direction: Direction, seenTuples: Set[(Int, Int)], heightIndex: Int, widthIndex: Int, counter: Int): Array[Array[Int]] = {
      if(counter > numberOfElements) array
      else {  
        (direction, canMove(seenTuples, heightIndex, widthIndex)) match {

          case (RIGHT, false) => iter(DOWN, seenTuples, heightIndex + 1, widthIndex - 1, counter)
          case (RIGHT, true) => 
            array(heightIndex)(widthIndex) = counter
            iter(RIGHT, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex, widthIndex + 1, counter + 1)

          case (DOWN, false) => iter(LEFT, seenTuples, heightIndex - 1, widthIndex - 1, counter)
          case (DOWN, true) => 
            array(heightIndex)(widthIndex) = counter
            iter(DOWN, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex + 1, widthIndex, counter + 1)

          case (LEFT, false) => iter(UP, seenTuples, heightIndex - 1, widthIndex + 1, counter)
          case (LEFT, true) => 
            array(heightIndex)(widthIndex) = counter
            iter(LEFT, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex, widthIndex - 1, counter + 1)

          case (UP, false) => iter(RIGHT, seenTuples, heightIndex + 1, widthIndex + 1, counter)
          case (UP, true) => 
            array(heightIndex)(widthIndex) = counter
            iter(UP, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex - 1, widthIndex, counter + 1)
        }
      }
    }

    iter(RIGHT, Set.empty, 0, 0, 1)
  }
}