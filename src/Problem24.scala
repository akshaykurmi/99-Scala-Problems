/**
  * Lotto: Draw N different random numbers from the set 1..M
  */

import scala.util.Random

object Problem24 {
    def lotto(n: Int, m: Int): List[Int] = {
        Random.shuffle(List.range(1, m)).take(n)
    }
    
    def main(args: Array[String]): Unit = {
        println(lotto(6, 49))
    }
}
