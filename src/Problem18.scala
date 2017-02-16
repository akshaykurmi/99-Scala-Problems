/**
  * Extract a slice from a list
  */
object Problem18 {
    def slice(i: Int, j: Int, symbols: List[Symbol]): List[Symbol] = (i, j, symbols) match {
        case (a, b, _) if b <= a => Nil
        case (a, b, _ :: tail) if a > 0 => slice(a - 1, b - 1, tail)
        case (_, b, head :: tail) if b > 0 => head :: slice(0, b - 1, tail)
        case (_, _, list) => list
    }
    
    def main(args: Array[String]): Unit = {
        println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
}
