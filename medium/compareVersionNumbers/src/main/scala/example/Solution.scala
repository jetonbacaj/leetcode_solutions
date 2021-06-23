// package example


object Solution {

  def main(args: Array[String]): Unit = {
    // val result = compareVersion("7.5.2.4", "7.5.3")
    // val result = compareVersion("1.0.1", "1")
    // val result = compareVersion("0.1", "1.1")
    // val result = compareVersion("1.0", "1.0.0")

    val result = compareVersion("1.01", "1.001")


    println(s"result => $result")
  }  

  def compareVersion(version1: String, version2: String): Int = {
    val splitVersion1 = version1.split('.')
    val splitVersion2 = version2.split('.')

    val maxDigits = math.max(splitVersion1.length, splitVersion2.length) 
    
    if(maxDigits < 1) return -10

    val multiplier = math.pow(10, maxDigits- 1)

    def iter(baseMultiplier: Double, digits: List[String], acc: Double): Double = {
      digits match {
        case h::t => iter(baseMultiplier / 10, t, acc + (Integer.parseInt(h) * baseMultiplier))
        case Nil => acc
      }
    }

    val version1Converted = iter(multiplier, splitVersion1.toList, 0)
    val version2Converted = iter(multiplier, splitVersion2.toList, 0)


    println(s"version1[$version1] => ${version1Converted}")

    println(s"version2[$version2] => ${version2Converted}")

    version1Converted compareTo version2Converted

  }
}