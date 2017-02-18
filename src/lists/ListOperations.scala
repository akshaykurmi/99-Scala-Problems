package lists

import scala.util.Random

object ListOperations {
    
    // Problem 1
    def last[T](list: List[T]): Option[T] = list match {
        case head :: Nil => Some(head);
        case _ :: tail => last(tail);
        case _ => None;
    }
    
    
    
    // Problem 2
    def penultimate[T](list: List[T]): Option[T] = list match {
        case head :: _ :: Nil => Some(head)
        case _ :: tail => penultimate(tail)
        case _ => None
    }
    
    
    
    // Problem 3
    def head[T](list: List[T]): Option[T] = list match {
        case head :: _ => Some(head)
        case _ => None
    }
    
    def tail[T](list: List[T]): List[T] = list match {
        case _ :: tail => tail
        case _ => List()
    }
    def nthElement[T](n: Int, list: List[T]): Option[T] = n match {
        case 0 => head(list)
        case i if i > 0 => nthElement(i - 1, tail(list))
        case i if i < 0 => None
    }
    
    
    
    // Problem 4
    def length[T](list: List[T]): Int = list match {
        case _ :: Nil => 1
        case _ :: tail => 1 + length(tail)
        case _ => 0
    }
    
    
    
    // Problem 5
    def reverse[T](list: List[T]): List[T] = list match {
        case Nil => Nil
        case _ :: Nil => list
        case head :: tail => reverse(tail) ::: List(head)
    }
    
    
    
    // Problem 6
    def isPalindrome[T](list: List[T]): Boolean = {
        list == reverse(list)
    }
    
    
    
    // Problem 7
    def flatten(list: List[Any]): List[Any] = list match {
        case (head: List[_]) :: tail => flatten(head) ::: flatten(tail)
        case head :: tail => head :: flatten(tail)
        case Nil => Nil
    }
    
    
    
    // Problem 8
    def compress[T](list: List[T]): List[T] = {
        list.foldLeft(List[T]())((a, b) => {
            if (a.isEmpty || a.last != b) a ::: List(b)
            else a
        })
    }
    
    
    
    // Problem 9
    def pack[T](list: List[T]): List[List[T]] = {
        if (list != Nil) {
            val prefix = list.takeWhile((item) => item == list.head)
            prefix :: pack(list.drop(prefix.length))
        }
        else Nil
    }
    
    
    
    // Problem 10
    def encode[T](list: List[T]): List[(Int, T)] = {
        pack(list).map(
            (item) => (item.length, item.head)
        )
    }
    
    
    
    // Problem 11
    def encodeModified[T](list: List[T]): List[Any] = {
        encode(list).map(item => {
            if (item._1 == 1) item._2
            else item
        })
    }
    
    
    
    // Problem 12
    def decode[T](list: List[(Int, T)]): List[T] = {
        list.flatMap((item) => List.fill(item._1)(item._2))
    }
    
    
    
    // Problem 13
    def encodeDirect[T](list: List[T]): List[(Int, T)] = {
        if (list != Nil) {
            val (prefix, rest) = list.span((item) => item == list.head)
            (prefix.length, prefix.head) :: encodeDirect(rest)
        }
        else Nil
    }
    
    
    
    // Problem 14
    def duplicate[T](list: List[T]): List[T] = {
        list.flatMap((item) => List(item, item))
    }
    
    
    
    // Problem 15
    def duplicateN[T](n: Int, list: List[T]): List[T] = {
        list.flatMap((item) => List.fill(n)(item))
    }
    
    
    
    // Problem 16
    def drop[T](n: Int, list: List[T]): List[T] = {
        if (list == Nil) Nil
        else list.take(n - 1) ::: drop(n, list.drop(n))
    }
    
    
    
    // Problem 17
    def split[T](n: Int, list: List[T]): (List[T], List[T]) = (n, list) match {
        case (_, Nil) => (Nil, Nil)
        case (i, items) if i <= 0 => (Nil, items)
        case (i, head :: tail) if i > 0 =>
            val (a, b) = split(i - 1, tail)
            (head :: a, b)
    }
    
    
    
    // Problem 18
    def slice[T](i: Int, j: Int, list: List[T]): List[T] = (i, j, list) match {
        case (a, b, _) if b <= a => Nil
        case (a, b, _ :: tail) if a > 0 => slice(a - 1, b - 1, tail)
        case (_, b, head :: tail) if b > 0 => head :: slice(0, b - 1, tail)
        case (_, _, items) => items
    }
    
    
    
    // Problem 19
    def rotate[T](n: Int, list: List[T]): List[T] = (n, list) match {
        case (i, items) if i < 0 => rotate(items.length + i, items)
        case (i, head :: tail) if i > 0 => rotate(i-1, tail ::: List(head))
        case (0, items) => items
    }
    
    
    
    // Problem 20
    def removeAt[T](k: Int, list: List[T]): (List[T], T) = {
        def remove(k: Int, list: List[T]): List[T] = (k, list) match {
            case (_, Nil) => Nil
            case (0, _ :: tail) => tail
            case (i, head :: tail) => head :: remove(i - 1, tail)
        }
    
        if (list.indices contains k) (remove(k: Int, list: List[T]), list(k))
        else throw new IndexOutOfBoundsException("At index : " + k)
    }
    
    
    
    // Problem 21
    def insertAt[T](item: T, n: Int, list: List[T]): List[T] = (n, list) match {
        case (0, items) => item :: items
        case (i, head :: tail) => head :: insertAt(item, i - 1, tail)
        case (_, Nil) => Nil
    }
    
    
    
    // Problem 22
    def range(start: Int, end: Int): List[Int] = {
        if (start > end) Nil
        else start :: range(start + 1, end)
    }
    
    
    
    // Problem 23
    def randomSelect[T](n: Int, list: List[T]): List[T] = {
        if (n <= 0) Nil
        else {
            val (rest, item) = removeAt(Random.nextInt(list.length), list)
            item :: randomSelect(n - 1, rest)
        }
    }
    
    
    
    // Problem 24
    def lotto(n: Int, m: Int): List[Int] = {
        Random.shuffle(List.range(1, m)).take(n)
    }
    
    
    
    // Problem 25
    def randomPermute[T](list: List[T]): List[T] = {
        randomSelect(list.length, list)
    }
    
    
    
    // Problem 26
    def allCombinations[T](list: List[T]): List[List[T]] = list match {
        case Nil => List(Nil)
        case head :: tail =>
            allCombinations(tail).map((c) => head :: c) ::: allCombinations(tail)
    }
    def combinations[T](k: Int, list: List[T]): List[List[T]] = {
        allCombinations(list).filter((combination) => combination.length == k)
    }
    
    
    
    // Problem 27
    def group[T](numbers: List[Int], people: List[T]): List[List[List[T]]] = numbers match {
        case Nil => List(Nil)
        case head :: tail => combinations(head, people).flatMap(
            combination => group(tail, people.diff(combination)).map(
                elem => combination :: elem
            )
        )
    }
    
    
    
    // Problem 28
    def lsort[T](lists: List[List[T]]): List[List[T]] = {
        lists.sortBy(list => list.length)
    }
    def lsortFreq[T](lists: List[List[T]]): List[List[T]] = {
        val lengthList = lists.map((list) => list.length)
        lists.sortBy((list) => lengthList.count(elem => elem == list.length))
    }
}
