/**
  * Reverse a list
  */
object Problem05 {
    def reverse[T](list: List[T]): List[T] = list match {
        case Nil => Nil
        case _ :: Nil => list
        case head :: tail => reverse(tail) ::: List(head)
    }
    
    def main(args: Array[String]): Unit = {
        println(reverse(List(1, 2, 3, 4, 5, 6)))
        println(reverse(List(1)))
        println(reverse(List()))
    }
}
