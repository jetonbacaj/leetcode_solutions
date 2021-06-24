
object Solution {
  def main(args: Array[String]): Unit = {
    // val result = myPow(0.00001, 2147483647)
    val result = myPow(2, 10)
    // val result = myPow(2, -2147483648)
    println(s"result = $result")
  }  

  def myPow(x: Double, n: Int): Double = {
    val absN = if(n < 0) -BigInt(n).longValue else  BigInt(n).longValue

    @annotation.tailrec
    def iter(acc: Double, xValue: Double, nCounter: Long, multiplier: Int): Double = {
      absN compareTo nCounter match {
        // n == nCounter
        case 0 => 
          if(n < 0) 1/acc else acc

        // n > nCounter
        case 1 => 
          val newNCounter = nCounter + multiplier
          val newMultiplier = multiplier * 2

          if(nCounter + multiplier <= absN && newNCounter <= Int.MaxValue && newMultiplier > 0)
            iter(acc * xValue, xValue * xValue, newNCounter, newMultiplier)
          else iter(acc * x , x, nCounter + 1 , 1)

        // n < nCounter
        case _ => iter(acc, x, nCounter - multiplier, 1)
      }
    }

    if(n == 0) 1
    else if(n == 1) x
    else if(n == -1) 1/x
    else if (x == 1) x
    else iter(x, x, 1, 1)
  }
}