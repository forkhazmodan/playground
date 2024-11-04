package leetcode.problems.two_sum.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.leetcode.two_sum.hashmap.SolutionV1;

class SolutionV1Test {

  @Test
  void twoSum() {
    Assertions.assertArrayEquals(new int[]{0, 1}, SolutionV1.twoSum(new int[]{2, 7, 11, 15}, 9));
    Assertions.assertArrayEquals(new int[]{1, 2}, SolutionV1.twoSum(new int[]{3, 2, 4}, 6));
    Assertions.assertArrayEquals(new int[]{0, 1}, SolutionV1.twoSum(new int[]{3, 3}, 6));
  }
}
