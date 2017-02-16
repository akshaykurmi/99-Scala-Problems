/**
  * Remove the Kth element from a list
  */
object Problem20 {
    def removeAt(k: Int, symbols: List[Symbol]): (List[Symbol], Symbol) = {
        def remove(k: Int, symbols: List[Symbol]): List[Symbol] = (k, symbols) match {
            case (_, Nil) => Nil
            case (0, _ :: tail) => tail
            case (i, head :: tail) => {
                head :: remove(i - 1, tail)
            }
        }
        
        if (symbols.indices contains k) (remove(k: Int, symbols: List[Symbol]), symbols(k))
        else throw new IndexOutOfBoundsException("At index : " + k)
    }
    
    def main(args: Array[String]): Unit = {
        println(removeAt(13, List('a, 'b, 'c, 'd)))
    }
}
