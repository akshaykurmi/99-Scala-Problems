/**
  * Group the elements of a set into disjoint subsets
  */

import Problem26.combinations

object Problem27 {
    def group(numbers: List[Int], people: List[Symbol]): List[List[List[Symbol]]] = numbers match {
        case Nil => List(Nil)
        case head :: tail => combinations(head, people).flatMap(
            combination => group(tail, people.diff(combination)).map(
                elem => combination :: elem
            )
        )
    }
    
    def main(args: Array[String]): Unit = {
        println(group(List(2, 3, 4), List('Aldo, 'Beat, 'Carla, 'David, 'Evi, 'Flip, 'Gary, 'Hugo, 'Ida)))
    }
}
