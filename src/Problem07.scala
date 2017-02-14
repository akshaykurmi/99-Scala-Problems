/**
  * Flatten a nested list structure
  */
object Problem07 {
    def flatten(list: List[Any]): List[Any] = list match {
        case (head: List[_]) :: tail => flatten(head) ::: flatten(tail)
        case head :: tail => head :: flatten(tail)
        case Nil => Nil
    }
    
    def main(args: Array[String]): Unit = {
        println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
    }
}
