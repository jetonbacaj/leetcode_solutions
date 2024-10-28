object Solution {
    def shortestPalindrome(input: String): String = {
        if(input == null || input.size < 2) input // base case?
        else if(input.size == 2) { 
            if (checkCharsMatchingAtIndexes(input, 0, 1)) // base case?
                input
            else 
                input.prepended(input.last) 
        }
        else {
            val lastIndexOfInput = input.size - 1

            def iter (index: Int, longestPalindrome: Int): Int = {
                index == lastIndexOfInput match {
                    case true => 
                        if(isRangeAPalindrome(input, 0, index)) index
                        else longestPalindrome

                    case _ => 
                        if(isRangeAPalindrome(input, 0, index)) iter(index + 1, index)
                        else iter(index + 1, longestPalindrome)
                }
            }     

            val offset = iter(1, 0) + 1
            val sliced = input.slice(offset, input.size)
            sliced.reverse.appendedAll(input)    
        }
    }

    private def checkCharsMatchingAtIndexes(input: String, idx1: Int, idx2: Int): Boolean =  input.charAt(idx1) == input.charAt(idx2)

    private def isRangeAPalindrome(input: String, startIndex: Int, endIndex: Int): Boolean = {
        def iter(idx1: Int, idx2: Int): Boolean = {
            if (idx1 > idx2) true // in case when window length is even 
            else if(idx1 == idx2) checkCharsMatchingAtIndexes(input, idx1, idx2)
            else if(checkCharsMatchingAtIndexes(input, idx1, idx2)) iter(idx1+1, idx2-1)
            else false
        }

        iter(startIndex, endIndex)
    }

    def main(args: Array[String]): Unit = {
        // println("aacecaaa =>" + shortestPalindrome("aacecaaa"))
        // println("abcd =>" + shortestPalindrome("abcd"))
        // println("abbacd =>" + shortestPalindrome("abbacd"))
        println("aba =>" + shortestPalindrome("aba"))
    }
}