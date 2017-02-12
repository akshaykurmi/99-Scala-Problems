/**
  * Find the last element of a list
  */
object Problem01 {
    def last[T](list: List[T]): Option[T] = list match {
        case head :: Nil => Some(head);
        case _ :: tail => last(tail);
        case _ => None;
    }
    
    def main(args: Array[String]): Unit = {
        println(last(List(1,2,3)))
        println(last(List(4)))
        println(last(List()))
    }
}
