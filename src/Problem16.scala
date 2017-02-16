/**
  * Drop every nth element from a list
  */
object Problem16 {
    def drop(n: Int, symbols: List[Symbol]): List[Symbol] = {
        if (symbols == Nil) Nil
        else symbols.take(n - 1) ::: drop(n, symbols.drop(n))
    }
    
    def main(args: Array[String]): Unit = {
        println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
}
