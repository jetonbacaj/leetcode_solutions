import scala.collection.mutable.HashMap

object Solution {
  def main(args: Array[String]): Unit = {

    val words = Array("eat","tea","tan","ate","nat","bat")

    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    val result = groupAnagrams(words)
    println(s"result = $result")
  }  

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val anagramGroups = new HashMap[String, List[String]]()

    strs.foreach(word => {
      val sortedWord = word.sorted
      if(anagramGroups.contains(sortedWord)) {
        anagramGroups.get(sortedWord).foreach(list => anagramGroups.put(sortedWord, word :: list))
      } else anagramGroups.put(sortedWord, List(word))
    })

    anagramGroups.foldLeft(List[List[String]]())({
      case (x, y) => y._2 :: x
    })
  }
}