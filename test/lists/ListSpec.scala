package lists

import org.scalatest.{FlatSpec, Matchers}
import ListOperations._

class ListSpec extends FlatSpec with Matchers {
    it should "find the last element of a list" in {
        last(List(1, 2, 3)) should be(Some(3))
        last(List(4)) should be(Some(4))
        last(List()) should be(None)
    }
    
    it should "find the penultimate element of a list" in {
        penultimate(List(1, 2, 3, 4, 5)) should be(Some(4))
        penultimate(List(4, 5)) should be(Some(4))
        penultimate(List(4)) should be(None)
        penultimate(List()) should be(None)
    }
    
    it should "find the Nth element of the list" in {
        nthElement(2, List(1, 2, 3, 4, 5, 6)) should be(Some(3))
        nthElement(4, List(1, 2, 3, 4, 5, 6)) should be(Some(5))
        nthElement(1, List(6)) should be(None)
        nthElement(-1, List()) should be(None)
    }
    
    it should "find the number of elements in the list" in {
        ListOperations.length(List(1, 2, 3, 4, 5, 6, 7)) should be(7)
        ListOperations.length(List(1, 2, 3)) should be(3)
        ListOperations.length(List(1)) should be(1)
        ListOperations.length(List()) should be(0)
    }
    
    it should "reverse the list" in {
        reverse(List(1, 2, 3, 4, 5, 6)) should be(List(6, 5, 4, 3, 2, 1))
        reverse(List(1)) should be(List(1))
        reverse(List()) should be(List())
    }
    
    it should "check if the list is a palindrome" in {
        isPalindrome(List(1, 2, 3, 3, 2, 1)) should be(true)
        isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
        isPalindrome(List(1, 2, 3)) should be(false)
        isPalindrome(List()) should be(true)
    }
    
    it should "flatten a nested list" in {
        flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be(
            List(1, 1, 2, 3, 5, 8))
        flatten(List()) should be(List())
    }
    
    it should "eliminate consecutive duplicates of list elements" in {
        compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(
            List('a, 'b, 'c, 'a, 'd, 'e))
        compress(List('a, 'e)) should be(
            List('a, 'e))
        compress(List('a)) should be(
            List('a))
    }
    
    it should "pack consecutive duplicates of list elements into sub-lists" in {
        pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(
            List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
        pack(List('a, 'b, 'c, 'd, 'e)) should be(
            List(List('a), List('b), List('c), List('d), List('e)))
        pack(List()) should be(List())
    }
    
    it should "run-length encode the list" in {
        encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(
            List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
        encode(List()) should be(List())
    }
    
    it should "run-length encode the list if number of elements is more than 1" in {
        encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(
            List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
    }
    
    it should "decode a run-length encoded list" in {
        decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) should be(
            List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        decode(List()) should be(List())
    }
    
    it should "run-length encode a list directly" in {
        encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(
            List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    }
    
    it should "duplicate the elements of a list" in {
        duplicate(List('a, 'b, 'c, 'c, 'd)) should be(
            List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
    }
    
    it should "duplicate the elements of a list N times" in {
        duplicateN(3, List('a, 'b, 'c, 'c, 'd)) should be(
            List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
    }
    
    it should "drop every Nth element from the list" in {
        drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
            List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
    }
    
    it should "split a list into two parts" in {
        split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
            (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }
    
    it should "extract a slice from the list" in {
        slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
            List('d, 'e, 'f, 'g))
    }
    
    it should "rotate a list N places to the left" in {
        rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
            List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
        rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should be(
            List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
    }
    
    it should "remove the Kth element from the list" in {
        removeAt(3, List('a, 'b, 'c, 'd)) should be(
            (List('a, 'b, 'c), 'd))
        assertThrows[IndexOutOfBoundsException] {
            removeAt(13, List('a, 'b, 'c, 'd))
        }
    }
    
    it should "insert the element at the given position in the list" in {
        insertAt('new, 2, List('a, 'b, 'c, 'd)) should be(
            List('a, 'b, 'new, 'c, 'd))
    }
    
    it should "create a list of integers in the given range" in {
        range(4, 9) should be(
            List(4, 5, 6, 7, 8, 9))
    }
    
    it should "extract N randomly selected elements from the list" in {
        val symbols = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
        val selectedSymbols = randomSelect(3, symbols)
        selectedSymbols.length should be(3)
        selectedSymbols.foreach(symbol => symbols should contain(symbol))
    }
    
    it should "find N different random numbers in the given range" in {
        val numbers = lotto(6, 49)
        numbers.length should be(6)
        numbers.distinct.length should be(6)
        numbers.foreach(number => number should be <= 49)
        numbers.foreach(number => number should be >= 1)
    }
    
    it should "generate a random permutation of the list" in {
        val symbols = List('a, 'b, 'c, 'd, 'e, 'f)
        val permutation = randomPermute(symbols)
        permutation.length should be(symbols.length)
        permutation.foreach(symbol => symbols should contain(symbol))
    }
    
    it should "generate the combination of K distinct sets chosen from N list elements" in {
        val result = combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
        result should be(List(
            List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), List('a, 'b, 'f),
            List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c, 'f), List('a, 'd, 'e),
            List('a, 'd, 'f), List('a, 'e, 'f), List('b, 'c, 'd), List('b, 'c, 'e),
            List('b, 'c, 'f), List('b, 'd, 'e), List('b, 'd, 'f), List('b, 'e, 'f),
            List('c, 'd, 'e), List('c, 'd, 'f), List('c, 'e, 'f), List('d, 'e, 'f)
        ))
    }
    
    it should "group the elements of a set into disjoint subsets" in {
        val grouped = group(List(2, 1, 2), List('Aldo, 'Beat, 'Carla, 'David, 'Evi))
        grouped should be(List(
            List(List('Aldo, 'Beat), List('Carla), List('David, 'Evi)),
            List(List('Aldo, 'Beat), List('David), List('Carla, 'Evi)),
            List(List('Aldo, 'Beat), List('Evi), List('Carla, 'David)),
            List(List('Aldo, 'Carla), List('Beat), List('David, 'Evi)),
            List(List('Aldo, 'Carla), List('David), List('Beat, 'Evi)),
            List(List('Aldo, 'Carla), List('Evi), List('Beat, 'David)),
            List(List('Aldo, 'David), List('Beat), List('Carla, 'Evi)),
            List(List('Aldo, 'David), List('Carla), List('Beat, 'Evi)),
            List(List('Aldo, 'David), List('Evi), List('Beat, 'Carla)),
            List(List('Aldo, 'Evi), List('Beat), List('Carla, 'David)),
            List(List('Aldo, 'Evi), List('Carla), List('Beat, 'David)),
            List(List('Aldo, 'Evi), List('David), List('Beat, 'Carla)),
            List(List('Beat, 'Carla), List('Aldo), List('David, 'Evi)),
            List(List('Beat, 'Carla), List('David), List('Aldo, 'Evi)),
            List(List('Beat, 'Carla), List('Evi), List('Aldo, 'David)),
            List(List('Beat, 'David), List('Aldo), List('Carla, 'Evi)),
            List(List('Beat, 'David), List('Carla), List('Aldo, 'Evi)),
            List(List('Beat, 'David), List('Evi), List('Aldo, 'Carla)),
            List(List('Beat, 'Evi), List('Aldo), List('Carla, 'David)),
            List(List('Beat, 'Evi), List('Carla), List('Aldo, 'David)),
            List(List('Beat, 'Evi), List('David), List('Aldo, 'Carla)),
            List(List('Carla, 'David), List('Aldo), List('Beat, 'Evi)),
            List(List('Carla, 'David), List('Beat), List('Aldo, 'Evi)),
            List(List('Carla, 'David), List('Evi), List('Aldo, 'Beat)),
            List(List('Carla, 'Evi), List('Aldo), List('Beat, 'David)),
            List(List('Carla, 'Evi), List('Beat), List('Aldo, 'David)),
            List(List('Carla, 'Evi), List('David), List('Aldo, 'Beat)),
            List(List('David, 'Evi), List('Aldo), List('Beat, 'Carla)),
            List(List('David, 'Evi), List('Beat), List('Aldo, 'Carla)),
            List(List('David, 'Evi), List('Carla), List('Aldo, 'Beat))
        ))
    }
    
    it should "sort the list according to length of sub-lists" in {
        val lengthSorted = lsort(List(
            List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h),
            List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)
        ))
        val lengthFreqSorted = lsortFreq(List(
            List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
            List('i, 'j, 'k, 'l), List('m, 'n), List('o)
        ))
        lengthSorted should be(List(
            List('o), List('d, 'e), List('d, 'e), List('m, 'n),
            List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)
        ))
        lengthFreqSorted should be(List(
            List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h),
            List('d, 'e), List('d, 'e), List('m, 'n)
        ))
    }
}
