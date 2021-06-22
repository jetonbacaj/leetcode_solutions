object Solution {

  def main(args: Array[String]): Unit = {
    val res = searchRange(Array(0,0,1,1,2,2,2,2,3,3,4,4,4,5,6,6,6,7,8,8),8)

    println(res.toList)
  }  

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    /*
    n compare 10 match {
      case 0 => "ten"
      case 1 => "greater than ten"
      case -1 => "less than ten"
    })
    */

    ???
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}