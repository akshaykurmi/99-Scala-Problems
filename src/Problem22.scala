/**
  * Create a list containing all integers within a given range
  */
object Problem22 {
    def range(start: Int, end: Int): List[Int] = {
        if (start > end) Nil
        else start :: range(start + 1, end)
    }
    
    def main(args: Array[String]): Unit = {
        println(range(4, 9))
    }
}
