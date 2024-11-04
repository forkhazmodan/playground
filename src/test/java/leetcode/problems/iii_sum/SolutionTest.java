package leetcode.problems.iii_sum;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.leetcode.iii_sum.Solution;

class SolutionTest {

  @Test
  void threeSum() {
    List<List<Integer>> lists = Solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    lists.forEach(System.out::println);

    Assertions.assertEquals(2, lists.size());

    Assertions.assertTrue(Arrays.asList(-1, -1, 2).contains(lists.get(0).get(0)));
    Assertions.assertTrue(Arrays.asList(-1, -1, 2).contains(lists.get(0).get(1)));
    Assertions.assertTrue(Arrays.asList(-1, -1, 2).contains(lists.get(0).get(2)));

    Assertions.assertTrue(Arrays.asList(-1, 0, 1).contains(lists.get(1).get(0)));
    Assertions.assertTrue(Arrays.asList(-1, 0, 1).contains(lists.get(1).get(1)));
    Assertions.assertTrue(Arrays.asList(-1, 0, 1).contains(lists.get(1).get(2)));
  }
}
