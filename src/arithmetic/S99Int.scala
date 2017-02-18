package arithmetic

class S99Int(val value: Int) {
    
    import S99Int._
    
    
    // Problem 31
    def isPrime: Boolean = {
        if (value <= 1) false
        else if (value == 2) true
        else (2 to Math.sqrt(value).toInt).forall((number) => value % number != 0)
    }
    
    
    // Problem 33
    def isCoprimeTo(other: Int) : Boolean = {
        gcd(value, other) == 1
    }
    
    
    // Problem 34
    def totient: Int = {
        (1 to value).count(number => value isCoprimeTo number)
    }
}

object S99Int {
    
    implicit def intToS99Int(i: Int): S99Int = new S99Int(i)
    
    
    // Problem 32
    def gcd(first: Int, second: Int): Int = (first, second) match {
        case (a, b) if b == 0 => a
        case (a, b) => gcd(b, a % b)
    }
}
