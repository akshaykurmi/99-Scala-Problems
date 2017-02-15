/**
  * Duplicate the elements of a list
  */
object Problem14 {
    def duplicate(symbols: List[Symbol]): List[Symbol] = {
        symbols.flatMap((symbol) => List(symbol, symbol))
    }
    
    def main(args: Array[String]): Unit = {
        println(duplicate(List('a, 'b, 'c, 'c, 'd)))
    }
}
