
object Solution {
  def main(args: Array[String]): Unit = {
    // val s = "abcde"
    // val words = Array("a","bb","acd","ace")
    val s = "dsahjpjauf"
    val words = Array("ahjpjau","ja","ahbwzgqnuk","tnmlanowax")

    val result = numMatchingSubseq(s, words)
    println(s"result = $result")
  }  

  def numMatchingSubseq(s: String, words: Array[String]): Int = {
   
    // val sList = s.toList
    // val wordsList = words.toSet

    // def iter(stringList: List[Char], wordStrList: List[Char]): Int = {
    //   (stringList, wordStrList) match {
    //     case(sHead::sTail, wHead :: wTail) =>  
    //       if(sHead == wHead) iter(sTail, wTail)
    //       else iter(sTail, wordStrList)
    //     case(sHead::sTail, Nil) => 1
    //     case(Nil, wHead :: wTail) => 0
    //     case (Nil, Nil) => 1
    //   }
    // }
    // wordsList.toList.map(word => iter(sList, word.toList)).sum


    //
    // The above takes too much memory on leetcode submission - so the below is meant to work faster (and it does!)
    //
    def iterArray(stringStartIndex: Int, stringEndIndex: Int, word: String, wordStartIndex: Int, wordEndIndex: Int): Int = {
      if(stringStartIndex <= stringEndIndex && wordStartIndex <= wordEndIndex){
        if(s(stringStartIndex) == word(wordStartIndex)) iterArray(stringStartIndex + 1, stringEndIndex, word, wordStartIndex+1, wordEndIndex)
        else iterArray(stringStartIndex + 1, stringEndIndex, word, wordStartIndex, wordEndIndex) 
      } else if (stringStartIndex <= stringEndIndex && wordStartIndex > wordEndIndex) 1
      else if (stringStartIndex > stringEndIndex && wordStartIndex <= wordEndIndex) 0
      else if (stringStartIndex > stringEndIndex &&  wordStartIndex > wordEndIndex) 1
      else 0
    }

    words.map(word => iterArray(0, s.length -1, word, 0, word.length-1)).sum
    
  }
}