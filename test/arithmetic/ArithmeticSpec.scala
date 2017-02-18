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
    
    it should "calculate Euler's totient using the prime factors" in {
        9.totient(9.primeFactorsMultiplicity) should be(6)
        10.totient(10.primeFactorsMultiplicity) should be(4)
    }
    
    it should "compare the two methods to calculate Euler's totient" in {
        10090.compareTotientMethods()
    }
    
    it should "list prime number in the given range" in {
        primesInRange(7 to 19) should be(List(7, 11, 13, 17, 19))
        primesInRange(1 to 20) should be(List(2, 3, 5, 7, 11, 13, 17, 19))
    }
    
    it should "find the list of pairs of primes that sum up to the given integer" in {
        14.goldbach should be(List((3, 11), (7, 7)))
        20.goldbach should be(List((3, 17), (7, 13)))
        42.goldbach should be(List((5, 37), (11, 31), (13, 29), (19, 23)))
    }
    
    it should "list goldbach pairs with specified lower bound for even numbers in the given range" in {
        goldbachList(9 to 20, 0) should be(Map(
            10 -> List((3, 7), (5, 5)),
            14 -> List((3, 11), (7, 7)),
            20 -> List((3, 17), (7, 13)),
            12 -> List((5, 7)),
            18 -> List((5, 13), (7, 11)),
            16 -> List((3, 13), (5, 11))
        ))
        goldbachList(1 to 50, 15) should be(Map(
            42 -> List((19, 23)),
            46 -> List((17, 29), (23, 23)),
            38 -> List((19, 19)),
            34 -> List((17, 17)),
            48 -> List((17, 31), (19, 29)),
            50 -> List((19, 31)),
            40 -> List((17, 23)),
            36 -> List((17, 19))
        ))
    }
}
