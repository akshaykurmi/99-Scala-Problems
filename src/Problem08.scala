/**
  * Eliminate consecutive duplicates of list elements
  */
object Problem08 {
    def compress(symbols: List[Symbol]): List[Symbol] = {
        symbols.foldLeft(List[Symbol]())((a, b) => {
            if (a.isEmpty || a.last != b) a ::: List(b)
            else a
        })
    }
    
    def main(args: Array[String]): Unit = {
        println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
        println(compress(List('a, 'e)))
        println(compress(List('a)))
    }
}
