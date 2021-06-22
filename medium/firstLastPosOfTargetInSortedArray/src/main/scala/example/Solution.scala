object Solution {

  def main(args: Array[String]): Unit = {
    val res = searchRange(Array(0,0,1,1,2,2,2,2,3,3,4,4,4,5,6,6,6,7,8,8),8)

    println(res.toList)
  }  

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {

    val LEFT: Short = 0
    val RIGHT: Short = 1

    @annotation.tailrec
    def binarySearch(start: Int, end: Int, lowestIndexOfTargetSeen: Int, direction: Short): Int = {
      if (end < start) lowestIndexOfTargetSeen
      else {
        val mid: Int = start + (end - start) / 2

        (nums(mid) compareTo target, direction) match {
          case (0, LEFT) => binarySearch(start, mid - 1, mid, direction)
          case (0, RIGHT) => binarySearch(mid + 1, end, mid, direction)
          case (1, _) => binarySearch(start, mid - 1, lowestIndexOfTargetSeen, direction)
          case _ => binarySearch(mid + 1, end, lowestIndexOfTargetSeen, direction)
        }
      }
    }

    if(nums.length == 0) Array(-1, -1)
    else if (nums.length == 1) {
      if(nums(0) == target)  Array(0, 0) else Array(-1, -1)
    } else {
      val startIndex: Int = binarySearch(0, nums.length - 1, -1, LEFT)
      val endIndex: Int = binarySearch(startIndex + 1, nums.length - 1, startIndex, RIGHT)
      Array(startIndex, endIndex)
    }
  }
}