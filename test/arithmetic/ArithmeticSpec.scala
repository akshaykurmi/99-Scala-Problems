package arithmetic

import org.scalatest.{FlatSpec, Matchers}
import S99Int._

class ArithmeticSpec extends FlatSpec with Matchers {
    it should "check if the given integer is prime" in {
        1.isPrime should be(false)
        2.isPrime should be(true)
        7.isPrime should be(true)
        20.isPrime should be(false)
        787.isPrime should be(true)
    }
    
    it should "find the gcd of two numbers" in {
        gcd(6, 0) should be(6)
        gcd(4, 6) should be(2)
        gcd(36, 63) should be(9)
    }
    
    it should "check if two positive integers are co-prime" in {
        6.isCoprimeTo(15) should be(false)
        9.isCoprimeTo(10) should be(true)
        35.isCoprimeTo(64) should be(true)
    }
    
    it should "calculate the Euler's totient of the number" in {
        9.totient should be(6)
        10.totient should be(4)
    }
    
    it should "list the prime factors of a given positive integer" in {
        1.primeFactors should be(List())
        12.primeFactors should be(List(2, 2, 3))
        13.primeFactors should be(List(13))
        315.primeFactors should be(List(3, 3, 5, 7))
    }
    
    it should "list the prime factors along with the counts" in {
        1.primeFactorsMultiplicity should be(List())
        12.primeFactorsMultiplicity should be(List((2, 2), (3, 1)))
        315.primeFactorsMultiplicity should be(List((3, 2), (5, 1), (7, 1)))
    }
}
