package algorithms.searching.binary_search.linear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void search() {
    Assertions.assertEquals(4, Solution.search(new int[]{-1,0,3,5,9,12}, 9));
    Assertions.assertEquals(-1, Solution.search(new int[]{-1,0,3,5,9,12}, 2));
  }
}
