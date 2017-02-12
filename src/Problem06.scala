/**
  * Find out whether a list is a palindrome
  */

import Problem05.reverse

object Problem06 {
    def isPalindrome[T](list: List[T]): Boolean = {
        list == reverse(list)
    }
    
    def main(args: Array[String]): Unit = {
        println(isPalindrome(List(1,2,3,3,2,1)))
        println(isPalindrome(List(1,2,3,2,1)))
        println(isPalindrome(List(1,2,3)))
        println(isPalindrome(List()))
    }
}
