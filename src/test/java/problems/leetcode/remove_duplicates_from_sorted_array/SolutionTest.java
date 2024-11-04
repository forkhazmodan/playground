package problems.leetcode.remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void removeDuplicates() {

    Solution solution = new Solution();
    int i = solution.removeDuplicates(new int[]{1, 1, 2});
    Assertions.assertEquals(2, i);
  }
}
