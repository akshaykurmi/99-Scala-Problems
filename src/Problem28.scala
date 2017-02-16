/**
  * Sorting a list of lists according to length of sublists
  */
object Problem28 {
    def lsort(lists: List[List[Symbol]]): List[List[Symbol]] = {
        lists.sortBy(symbols => symbols.length)
    }
    
    def lsortFreq(lists: List[List[Symbol]]): List[List[Symbol]] = {
        val lengthList = lists.map((symbols) => symbols.length)
        lists.sortBy((symbols) => lengthList.count(elem => elem == symbols.length))
    }
    
    def main(args: Array[String]): Unit = {
        println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
            List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
        println(lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
            List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
    }
}
