package arithmetic

class S99Int(val start: Int) {
    
    // Problem 31
    def isPrime: Boolean ={
        if (start <= 1) false
        else if (start == 2) true
        else (2 to Math.sqrt(start).toInt).forall((number) => start % number != 0)
    }
}

object S99Int {
    implicit def intToS99Int(i: Int): S99Int = new S99Int(i)
}
