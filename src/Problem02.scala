/**
  * Find the penultimate element of a list
  */
object Problem02 {
    def penultimate[T](list: List[T]): Option[T] = list match {
        case head :: _ :: Nil => Some(head)
        case _ :: tail => penultimate(tail)
        case _ => None
    }
    
    def main(args: Array[String]): Unit = {
        println(penultimate(List(1, 2, 3, 4, 5)))
        println(penultimate(List(1, 2)))
        println(penultimate(List(4)))
        println(penultimate(List()))
    }
}
