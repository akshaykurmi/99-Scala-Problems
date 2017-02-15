/**
  * Decode a run-length encoded list
  */
object Problem12 {
    def decode(symbols: List[(Int, Symbol)]): List[Symbol] = {
        symbols.flatMap((symbol) => List.fill(symbol._1)(symbol._2))
    }
    
    def main(args: Array[String]): Unit = {
        println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
        println(decode(List()))
    }
}
