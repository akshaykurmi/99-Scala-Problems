/**
  * Duplicate the elements of a list a given number of times
  */
object Problem15 {
    def duplicateN(n: Int, symbols: List[Symbol]): List[Symbol] = {
        symbols.flatMap((symbol) => List.fill(n)(symbol))
    }
    
    def main(args: Array[String]): Unit = {
        println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
    }
}
