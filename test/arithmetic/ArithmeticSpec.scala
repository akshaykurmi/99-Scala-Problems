package arithmetic

import org.scalatest.{FlatSpec, Matchers}
import S99Int._

class ArithmeticSpec extends FlatSpec with Matchers{
    it should "check if the given integer is prime" in {
        1.isPrime should be (false)
        2.isPrime should be (true)
        7.isPrime should be (true)
        20.isPrime should be (false)
        787.isPrime should be (true)
    }
}
