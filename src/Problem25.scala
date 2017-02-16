/**
  * Generate a random permutation of the elements of a list
  */

import Problem20.removeAt
import scala.util.Random

object Problem25 {
    def randomSelect(n: Int, symbols: List[Symbol]): List[Symbol] = {
        if (n <= 0) Nil
        else {
            val (rest, symbol) = removeAt(Random.nextInt(symbols.length), symbols)
            symbol :: randomSelect(n - 1, rest)
        }
    }
    
    def randomPermute(symbols: List[Symbol]): List[Symbol] = {
        randomSelect(symbols.length, symbols)
    }
    
    def main(args: Array[String]): Unit = {
        println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    }
}
