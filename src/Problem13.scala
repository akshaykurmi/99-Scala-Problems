/**
  * Run-length encoding of a list (direct solution)
  */
object Problem13 {
    def encodeDirect(symbols: List[Symbol]): List[(Int, Symbol)] = {
        if (symbols != Nil) {
            val (prefix, rest) = symbols.span((symbol) => symbol == symbols.head)
            (prefix.length, prefix.head) :: encodeDirect(rest)
        }
        else Nil
    }
    
    def main(args: Array[String]): Unit = {
        println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    }
}
