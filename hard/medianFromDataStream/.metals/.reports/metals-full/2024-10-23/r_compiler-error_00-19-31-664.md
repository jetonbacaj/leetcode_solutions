file://<WORKSPACE>/src/main/scala/example/Solution.scala
### file%3A%2F%2F%2Fhome%2Fr00t%2Fcode%2Fleetcode_solutions%2Fhard%2FmedianFromDataStream%2Fsrc%2Fmain%2Fscala%2Fexample%2FSolution.scala:34: error: `end of file` expected but `}` found
}
^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.14
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.14/scala-library-2.13.14.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/src/main/scala/example/Solution.scala
text:
```scala
import scala.collection.mutable.PriorityQueue

object Solution {

    def main(args: Array[String]): Unit = {
        val medianFinder = new MedianFinder()
        medianFinder.addNum(2)    // arr = [1]
        medianFinder.addNum(3)    // arr = [1, 2]
        println(medianFinder.findMedian()) // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(4)    // arr[1, 2, 3]
        println(medianFinder.findMedian()) // return 2.0

    }


    class MedianFinder() {
        private val pq = new PriorityQueue[Int]()
        
        def addNum(num: Int): Unit = pq.addOne(num)
        
        def findMedian(): Double = {

            val array = pq.toArray
            val arraySize = array.size

            if(arraySize % 2 == 0){
                (array((arraySize-1)/2) + array(arraySize/2)).doubleValue() / 2
            } else 
array(arraySize/2+1).doubleValue()
            }
        }
    }

}
```



#### Error stacktrace:

```
scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$expectAt(ScalametaParser.scala:396)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$expectAt(ScalametaParser.scala:400)
	scala.meta.internal.parsers.ScalametaParser.expect(ScalametaParser.scala:402)
	scala.meta.internal.parsers.ScalametaParser.accept(ScalametaParser.scala:418)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:62)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:53)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:116)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:30)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:37)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:22)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:15)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:161)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:469)
```
#### Short summary: 

file%3A%2F%2F%2Fhome%2Fr00t%2Fcode%2Fleetcode_solutions%2Fhard%2FmedianFromDataStream%2Fsrc%2Fmain%2Fscala%2Fexample%2FSolution.scala:34: error: `end of file` expected but `}` found
}
^