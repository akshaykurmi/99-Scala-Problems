/**
  * Rotate a list N places to the left
  */
object Problem19 {
    def rotate(n: Int, symbols: List[Symbol]): List[Symbol] = (n, symbols) match {
        case (i, list) if i < 0 => rotate(list.length + i, list)
        case (i, head :: tail) if i > 0 => rotate(i-1, tail ::: List(head))
        case (0, list) => list
    }
    
    def main(args: Array[String]): Unit = {
        println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
}
