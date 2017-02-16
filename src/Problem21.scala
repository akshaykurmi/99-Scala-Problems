/**
  * Insert an element at a given position into a list
  */
object Problem21 {
    def insertAt(symbol: Symbol, n: Int, symbols: List[Symbol]): List[Symbol] = (n, symbols) match {
        case (0, list) => symbol :: list
        case (i, head :: tail) => head :: insertAt(symbol, i - 1, tail)
        case (_, Nil) => Nil
    }
    
    def main(args: Array[String]): Unit = {
        println(insertAt('new, 2, List('a, 'b, 'c, 'd)))
    }
}
