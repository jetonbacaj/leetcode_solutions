
object Solution {
  def main(args: Array[String]): Unit = {
    // val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    val matrix = Array(Array(5,1,9,11),Array(2,4,8,10),Array(13,3,6,7),Array(15,14,12,16))

    print("Before")
    print2DArray[Int](matrix)
    rotate(matrix)

    println
    println
    print("After")
    print2DArray[Int](matrix)
  }  

  private def print2DArray[A](matrix: Array[Array[A]]): Unit = {
    matrix.foreach(c => {
      println
      c.foreach(x => print(s"$x,\t"))
    })
  }

  //
  // Taken from https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
  // The idea/implementation belongs to the author above
  // 

  def rotate(matrix: Array[Array[Int]]): Unit = {
    if(matrix.length > 1) {

      var start = 0
      var end = matrix.length - 1

      while(start < end){
          val temp = matrix(start)
          matrix(start) = matrix(end)
          matrix(end) = temp
          start += 1
          end -= 1
      }

      for(x <- 0 to matrix.length - 1){
        for(y <- x + 1 to matrix.length - 1){
          val temp = matrix(x)(y)
          matrix(x)(y) = matrix(y)(x)
          matrix(y)(x) = temp
        }
      }
    }
  }
}