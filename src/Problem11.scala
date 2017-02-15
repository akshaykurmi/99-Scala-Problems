/**
  * Modify run-length encoding
  */

import Problem10.encode

object Problem11 {
    def encodeModified(symbols: List[Symbol]): List[Any] = {
        encode(symbols).map(symbol => {
            if (symbol._1 == 1) symbol._2
            else symbol
        })
    }
    
    def main(args: Array[String]): Unit = {
        println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    }
}
