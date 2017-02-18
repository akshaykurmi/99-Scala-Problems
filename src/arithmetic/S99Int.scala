package arithmetic

class S99Int(val value: Int) {
    
    import S99Int._
    import lists.ListOperations.encode
    import System.{currentTimeMillis => time}
    
    
    // Problem 31
    def isPrime: Boolean = {
        if (value <= 1) false
        else if (value == 2) true
        else (2 to Math.sqrt(value).toInt).forall((number) => value % number != 0)
    }
    
    
    // Problem 33
    def isCoprimeTo(other: Int): Boolean = {
        gcd(value, other) == 1
    }
    
    
    // Problem 34
    def totient: Int = {
        (1 to value).count(number => value isCoprimeTo number)
    }
    
    
    // Problem 35
    def primeFactors: List[Int] = {
        def accumulateFactors(num: Int, primes: List[Int]): List[Int] = (num, primes) match {
            case (n, _) if n isPrime => List(n)
            case (n, head :: _) if n % head == 0 => head :: accumulateFactors(n / head, primes)
            case (n, _ :: tail) => accumulateFactors(n, tail)
            case (_, Nil) => Nil
        }
        
        val primes = primesInRange(2 to Math.sqrt(value).toInt + 1)
        accumulateFactors(value, primes)
    }
    
    
    // Problem 36
    def primeFactorsMultiplicity: List[(Int, Int)] = {
        encode(value.primeFactors) map {
            _.swap
        }
    }
    
    
    // Problem 37
    def totient(primeFactors: List[(Int, Int)]): Int = {
        primeFactors.foldLeft(1)((a, b) => a * (b._1 - 1) * Math.pow(b._1, b._2 - 1).toInt)
    }
    
    
    // Problem 38
    def compareTotientMethods(): Unit = {
        val factors = value.primeFactorsMultiplicity
        val start1 = time()
        println("Comparing the two methods to calculate Euler's totient")
        println("Counting co-primes : " + value.totient + "" + (time() - start1) + " milliseconds")
        val start2 = time()
        println("Using prime factors : " + value.totient(factors) + "" + (time() - start2) + " milliseconds")
    }
    
    
    // Problem 40
    def goldbach: List[(Int, Int)] = {
        primesInRange(1 to value)
            .filter(number => (value - number).isPrime && number <= value - number)
            .map(number => (number, value - number))
    }
}

object S99Int {
    
    implicit def intToS99Int(i: Int): S99Int = new S99Int(i)
    
    
    // Problem 32
    def gcd(first: Int, second: Int): Int = (first, second) match {
        case (a, b) if b == 0 => a
        case (a, b) => gcd(b, a % b)
    }
    
    
    // Problem 39
    def primesInRange(range: Range): List[Int] = {
        range.toList filter {
            _.isPrime
        }
    }
}
