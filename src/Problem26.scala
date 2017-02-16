/**
  * Generate the combinations of K distinct objects chosen from the N elements of a list
  */
object Problem26 {
    def allCombinations(symbols: List[Symbol]): List[List[Symbol]] = symbols match {
        case Nil => List(Nil)
        case head :: tail =>
            allCombinations(tail).map((c) => head :: c) ::: allCombinations(tail)
    }
    
    def combinations(k: Int, symbols: List[Symbol]): List[List[Symbol]] = {
        allCombinations(symbols).filter((combination) => combination.length == k)
    }
    
    def main(args: Array[String]): Unit = {
        println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
    }
}
