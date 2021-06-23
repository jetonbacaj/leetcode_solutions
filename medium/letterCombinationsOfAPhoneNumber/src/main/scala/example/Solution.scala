
object Solution {

  private val numberToLettersMap = Map(
        '2' -> List("a", "b", "c"),
        '3' -> List("d", "e", "f"),
        '4' -> List("g", "h", "i"),
        '5' -> List("j", "k", "l"),
        '6' -> List("m", "n", "o"),
        '7' -> List("p", "q", "r", "s"),
        '8' -> List("t", "u", "v"),
        '9' -> List("w", "x", "y", "z"),
    )
    
  def letterCombinations(digits: String): List[String] = {
    def iter(acc: List[List[String]], digits: List[Char]): List[List[String]] = {
      digits match {
        case h::t => {
          val numberToDigitList = numberToLettersMap.get(h)

          if(numberToDigitList.isDefined)     
            iter(acc.map(a => numberToDigitList.get.map(digList => digList :: a)).flatten , t) 
          else 
            iter(acc, t)
          }
          
        case Nil => acc 
      }  
    }

    if(digits.length < 1) List.empty
    else iter(List(List()), digits.toList).map(x=>x.reverse.mkString)
  }
}