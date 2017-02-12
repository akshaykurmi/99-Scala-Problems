/**
  * Find the nth element of a list
  */
object Problem03 {
    def head[T](list: List[T]): Option[T] = list match {
        case head :: _ => Some(head)
        case _ => None
    }
    
    def tail[T](list: List[T]): List[T] = list match {
        case _ :: tail => tail
        case _ => List()
    }
    
    def nthElement[T](n: Int, list: List[T]): Option[T] = n match {
        case 0 => head(list)
        case n if n > 0 => nthElement(n - 1, tail(list))
        case n if n < 0 => None
    }
    
    def main(args: Array[String]): Unit = {
        println(nthElement(2, List(1, 2, 3, 4, 5, 6)))
        println(nthElement(4, List(1, 2, 3, 4, 5, 6)))
        println(nthElement(1, List(6)))
        println(nthElement(-1, List()))
    }
}
