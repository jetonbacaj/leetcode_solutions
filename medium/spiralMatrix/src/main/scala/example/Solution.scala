
object Solution {

  def main(args: Array[String]): Unit = {

    val in = Array(Array(1,2,3) )//, Array(4,5,6), Array(7,8,9))

    val result = spiralOrder(in)
    println(s"result = $result")
  }  

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val heighSize = matrix.length
    val widthSize = matrix(0).length
    val numberOfElements = widthSize * heighSize

    sealed trait Direction
    case object RIGHT extends Direction
    case object DOWN extends Direction
    case object LEFT extends Direction
    case object UP extends Direction

    def canMove(seenTuples: Set[(Int, Int)], heightIndex: Int, widthIndex: Int): Boolean = 
       widthIndex > -1 && 
       widthIndex < widthSize && 
       heightIndex > -1 && 
       heightIndex < heighSize && 
       !seenTuples.contains((heightIndex, widthIndex))

    @annotation.tailrec
    def iter(direction: Direction, seenTuples: Set[(Int, Int)], heightIndex: Int, widthIndex: Int, acc: List[Int]): List[Int] = {
      if(acc.size == numberOfElements) acc.reverse
      else{
        (direction, canMove(seenTuples, heightIndex, widthIndex)) match {

          case (RIGHT, false) => iter(DOWN, seenTuples, heightIndex + 1, widthIndex - 1, acc)
          case (RIGHT, true) => iter(RIGHT, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex, widthIndex + 1, matrix(heightIndex)(widthIndex) :: acc)

          case (DOWN, false) => iter(LEFT, seenTuples, heightIndex - 1, widthIndex - 1, acc)
          case (DOWN, true) => iter(DOWN, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex + 1, widthIndex, matrix(heightIndex)(widthIndex) :: acc)

          case (LEFT, false) => iter(UP, seenTuples, heightIndex - 1, widthIndex + 1, acc)
          case (LEFT, true) => iter(LEFT, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex, widthIndex - 1, matrix(heightIndex)(widthIndex) :: acc)

          case (UP, false) => iter(RIGHT, seenTuples, heightIndex + 1, widthIndex + 1, acc)
          case (UP, true) => iter(UP, seenTuples + Tuple2(heightIndex, widthIndex), heightIndex - 1, widthIndex, matrix(heightIndex)(widthIndex) :: acc)
        }
      }
    }

    iter(RIGHT, Set.empty, 0, 0, List.empty)
  }
}