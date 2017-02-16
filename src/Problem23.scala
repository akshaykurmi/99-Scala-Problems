/**
  * Extract a given number of randomly selected elements from a list
  */

import Problem20.removeAt
import scala.util.Random

object Problem23 {
    def randomSelect(n: Int, symbols: List[Symbol]): List[Symbol] = {
        if (n < 0) Nil
        else if (n >= symbols.length) symbols
        else randomSelect(n, removeAt(Random.nextInt(symbols.length), symbols)._1)
    }
    
    def main(args: Array[String]): Unit = {
        println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    }
}
