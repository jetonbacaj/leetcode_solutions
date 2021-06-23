
object Solution {

  def main(args: Array[String]): Unit = {
    println(searchMatrix(
      Array(
        Array(1,3,5,7),
        Array(10,11,16,20),
        Array(23,30,34,60)
      ),
      11
    )
    )
  }  

  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    @annotation.tailrec
    def iterIndex(array: Array[Array[Int]], startIndex: Int, endIndex: Int): Int = {
      val distance = endIndex - startIndex
      if(distance == 0) startIndex
      else if(distance == 1)  {
        if(array(endIndex)(0) <= target) endIndex else startIndex
      } else {
        val mid = startIndex + distance / 2
        if(array(mid)(0) == target) mid
        else if(array(mid)(0) > target) iterIndex(array, startIndex, mid - 1)
        else iterIndex(array, mid, endIndex)
      }
    }

    val indexToWorkWith = iterIndex(matrix, 0, matrix.length - 1)

    @annotation.tailrec
    def iter(array: Array[Int], startIndex: Int, endIndex: Int): Boolean = {
      val distance = endIndex - startIndex
      if(distance == 0) array(startIndex) == target
      else if(distance == 1)  array(startIndex) == target || array(endIndex) == target
      else {
        val mid = startIndex + distance / 2
        if(array(mid) == target) true
        else if(array(mid) > target) iter(array, startIndex, mid - 1)
        else iter(array, mid + 1, endIndex)
      }
    }

    val arrayToSearch = matrix(indexToWorkWith)
    iter(arrayToSearch, 0, arrayToSearch.length - 1)
  }
}