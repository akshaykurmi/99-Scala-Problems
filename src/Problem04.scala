/**
  * Find the number of elements in a list
  */
object Problem04 {
    def length[T](list: List[T]): Int = list match {
        case _ :: Nil => 1
        case _ :: tail => 1 + length(tail)
        case _ => 0
    }
    
    def main(args: Array[String]): Unit = {
        println(length(List(1, 2, 3, 4, 5, 6, 7)))
        println(length(List(1, 2, 3)))
        println(length(List(1)))
        println(length(List()))
    }
}
