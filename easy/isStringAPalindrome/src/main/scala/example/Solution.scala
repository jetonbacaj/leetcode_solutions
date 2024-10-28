
object Solution {
    def isPalindrome(input: String): Boolean = {
        def isRangeAPalindrome(idx1: Int, idx2: Int): Boolean = {
            if(idx1 == 0) 
                input.charAt(idx1) == input.charAt(idx2)
            else if(input.charAt(idx1) == input.charAt(idx2)) 
                isRangeAPalindrome(idx1-1, idx2+1)
            else false
        }

        if(input == null) true // base case?
        else if(input.size == 0) true // base case?
        else if(input.size == 1) true // base case?
        else if(input.size == 2) isRangeAPalindrome(0, 1) // base case?
        else if(input.size % 2 == 0) //even 
            isRangeAPalindrome(input.size/2-1, input.size/2)
        else 
            isRangeAPalindrome(input.size/2-1, input.size/2+1)

    }

    def main(args: Array[String]): Unit = {
        println("abba \t = " + isPalindrome("abba"))
        println("abbba \t = " + isPalindrome("abbba"))
        println("abbca \t = " + isPalindrome("abbca"))
        println("aa \t = " + isPalindrome("aa"))
        println("a \t = " + isPalindrome("a"))
        println("'' \t = " + isPalindrome(""))
        println("NULL \t = " + isPalindrome(null))
    }
}