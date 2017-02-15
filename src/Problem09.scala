/**
  * Pack consecutive duplicates of list elements into sublists
  */
object Problem09 {
    def pack(symbols: List[Symbol]): List[List[Symbol]] = {
        if (symbols != Nil) {
            val prefix = symbols.takeWhile((symbol) => symbol == symbols.head)
            prefix :: pack(symbols.drop(prefix.length))
        }
        else Nil
    }
    
    def main(args: Array[String]): Unit = {
        println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
        println(pack(List('a, 'b, 'c, 'd, 'e)))
        println(pack(List()))
    }
}
