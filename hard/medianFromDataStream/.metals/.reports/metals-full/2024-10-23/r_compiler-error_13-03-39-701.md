file://<WORKSPACE>/src/main/scala/example/Solution.scala
### java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Types$Type.typeSymbol()" because "tp" is null

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.14
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.14/scala-library-2.13.14.jar [exists ]
Options:



action parameters:
offset: 1618
uri: file://<WORKSPACE>/src/main/scala/example/Solution.scala
text:
```scala
import scala.collection.mutable.PriorityQueue

object Solution {

    def main(args: Array[String]): Unit = {
        val medianFinder = new MedianFinder()


        // medianFinder.addNum(-1)   
        // println(medianFinder.findMedian()) 
        // medianFinder.addNum(-2)   
        // println(medianFinder.findMedian())
        // medianFinder.addNum(-3)   
        // println(medianFinder.findMedian())
        // medianFinder.addNum(-4)   
        // println(medianFinder.findMedian())
        // medianFinder.addNum(-5)   
        // println(medianFinder.findMedian())

        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        println(medianFinder.findMedian()); // return 2.0
    }

    class MedianFinder() {

        private val pq = new scala.collection.mutable.PriorityQueue[Int]()
        
        def addNum(num: Int): Unit = pq.enqueue(num)
        
        def findMedian(): Double = {

            var array = pq.clone.dequeueAll.toArray
            var arraySize = array.size
            var ret = 0.0;

            if(arraySize == 1) {
                ret = array(0).doubleValue
            } else if(arraySize % 2 == 0){
                ret = (array((arraySize-1)/2) + array(arraySize/2)).doubleValue() / 2
                
            } else { 
                ret = array(arraySize/2).doubleValue()
            }
            
            array = null
            ret
        }

        private def getArrayBuffer()@@

}
}
```



#### Error stacktrace:

```
scala.reflect.internal.Definitions$DefinitionsClass.isByNameParamType(Definitions.scala:428)
	scala.reflect.internal.TreeInfo.isStableIdent(TreeInfo.scala:140)
	scala.reflect.internal.TreeInfo.isStableIdentifier(TreeInfo.scala:113)
	scala.reflect.internal.TreeInfo.isPath(TreeInfo.scala:102)
	scala.tools.nsc.interactive.Global.stabilizedType(Global.scala:974)
	scala.tools.nsc.interactive.Global.typedTreeAt(Global.scala:822)
	scala.meta.internal.pc.SignatureHelpProvider.signatureHelp(SignatureHelpProvider.scala:23)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$signatureHelp$1(ScalaPresentationCompiler.scala:339)
```
#### Short summary: 

java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Types$Type.typeSymbol()" because "tp" is null