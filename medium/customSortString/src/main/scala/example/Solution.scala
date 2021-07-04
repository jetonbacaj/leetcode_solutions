import scala.collection.mutable.HashMap

object Solution {
  def main(args: Array[String]): Unit = {
    val order = "cba"
    val str = "abcd"

    val result = customSortString(order, str)
    println(s"result = $result")
  }  

  def customSortString(order: String, str: String): String = {
    val mapToChar = new HashMap[Char, Int]()

    str.foreach(c => if(mapToChar.contains(c)) mapToChar.put(c, mapToChar.get(c).get + 1) else mapToChar.put(c, 1))

    val stringBuilder = new StringBuilder

    order.foreach(c => { 
      if(mapToChar.contains(c)) {
        mapToChar.get(c).foreach(counter => for(i <- 1 to counter) stringBuilder.addOne(c))
        mapToChar.remove(c)
      }
    })

    mapToChar.foreachEntry((k, v) => for(i <- 1 to v) stringBuilder.addOne(k))
    stringBuilder.toString()
  }
}