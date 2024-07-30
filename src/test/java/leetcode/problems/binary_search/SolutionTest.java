package leetcode.problems.binary_search;

import algorithms.searching.binary_search.recursive.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void search() {
    Assertions.assertEquals(0, Solution.search(new int[] {1}, 1));
    Assertions.assertEquals(7, Solution.search(new int[] {-1,0,3,5,6,7,8,9,12}, 9));
    Assertions.assertEquals(4, Solution.search(new int[] {-1,0,3,5,9}, 9));
    Assertions.assertEquals(0, Solution.search(new int[] {-1,0,3,5,9}, -1));
    Assertions.assertEquals(1, Solution.search(new int[] {5,9}, 9));
    Assertions.assertEquals(0, Solution.search(new int[] {9}, 9));
    Assertions.assertEquals(-1, Solution.search(new int[] {}, 9));
  }
}
