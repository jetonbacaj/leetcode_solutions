object Solution {

  def main(args: Array[String]): Unit = {

    val foo = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))

    print("before: [")
    printLinkedList(foo)

    val bar = removeNthFromEnd(foo,6)

    print("after: [")
    printLinkedList(bar)
  }  

  def printLinkedList(head: ListNode){
    if(head == null) println("]")
    else {
      print(s"${head.x},")
      printLinkedList(head.next)
    }
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    @annotation.tailrec
    def countIter(workingHead: ListNode, count: Int): Int = {
      workingHead match {
        case null => count
        case _ => countIter(workingHead.next, count + 1)
      }
    }

    @annotation.tailrec
    def iter(last: Option[ListNode], curr: ListNode, counter: Int): ListNode = {
      (counter compareTo 0) match {
        case 0 => 
          last.map(l => l.next = curr.next)
          head

        case 1 => iter(Some(curr), curr.next, counter - 1)
        case _ => throw new RuntimeException("This should not happen!")
      }
    }

    val elementCount = countIter(head, 0)
    val difference = elementCount - n

    if(difference < 0) null
    else if (n < 1) head
    else if (difference == 0) head.next
    else if(elementCount == n) head
    else iter(None, head, difference)  
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}