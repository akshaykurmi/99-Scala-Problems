/**
  * Run-length encoding of a list
  */

import Problem09.pack

object Problem10 {
    def encode(symbols: List[Symbol]): List[(Int, Symbol)] = {
        pack(symbols).map(
            (symbol) => (symbol.length, symbol.head)
        )
    }
    
    def main(args: Array[String]): Unit = {
        println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
        println(encode(List()))
    }
}
