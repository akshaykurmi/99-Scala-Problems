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
    
    it should "find the gcd of two numbers" in {
        gcd(6, 0) should be (6)
        gcd(4, 6) should be (2)
        gcd(36, 63) should be (9)
    }
    
    it should "check if two positive integers are co-prime" in {
        6.isCoprimeTo(15) should be (false)
        9.isCoprimeTo(10) should be (true)
        35.isCoprimeTo(64) should be (true)
    }
}
