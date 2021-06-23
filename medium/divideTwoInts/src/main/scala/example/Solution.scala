// package example


object Solution {

  def main(args: Array[String]): Unit = {
    val dividend = -231
    val divisor = 3

    // val dividend = 1100540749
    // val divisor = -1090366779
    
    val result = divide(dividend, divisor)
    println(s"$dividend/$divisor = $result")
  }  

  def divide(dividend: Int, divisor: Int): Int = {
    val negDivident = math.min(dividend, -dividend)
    val negDivisor = math.min(divisor, -divisor)

    @annotation.tailrec
    def iter(dDent: Int, dVisor: Int, acc: Int, divisorMultiplier: Int): Int = {

      val comparison = dDent compareTo dVisor

      (comparison) match {

        case 0 => acc - divisorMultiplier

        case -1 => if(dVisor > 0) acc else  iter(dDent - dVisor, dVisor + dVisor, acc - divisorMultiplier, divisorMultiplier + divisorMultiplier)

        case _ => 
          if(dDent <= negDivisor) iter(dDent - negDivisor, negDivisor, acc - 1, 1)
          else acc
      }
    }

    def convertToCorrectSignage(result: Int): Int = {
      if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
        if (result == Int.MinValue) Int.MaxValue else -result
      } else if(dividend < 0 || divisor < 0) {
        result
      } else {
        throw new RuntimeException("Bang!")
      }
    }

    if(dividend == 0 || divisor == 0) 0
    else if(math.abs(dividend) == math.abs(divisor)) convertToCorrectSignage(-1)
    else if(math.abs(divisor) == 1) convertToCorrectSignage(-dividend)
    else convertToCorrectSignage(iter(negDivident, negDivisor, 0, 1))
  }
}