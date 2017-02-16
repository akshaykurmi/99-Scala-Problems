/**
  * Split a list into two parts
  */
object Problem17 {
    def split(n: Int, symbols: List[Symbol]): (List[Symbol], List[Symbol]) = (n, symbols) match {
        case (_, Nil) => (Nil, Nil)
        case (i, list) if i <= 0 => (Nil, list)
        case (i, head :: tail) if i > 0 => {
            val (a, b) = split(i - 1, tail)
            (head :: a, b)
        }
    }
    
    def main(args: Array[String]): Unit = {
        println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
}
