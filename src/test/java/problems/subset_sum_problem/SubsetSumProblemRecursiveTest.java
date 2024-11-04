package problems.subset_sum_problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubsetSumProblemRecursiveTest {

  @Test
  void findSubset() {
    int[] subset = SubsetSumProblemRecursive.findSubset(new int[]{1, -2, 6, 7, 1}, 0);

    for (int i : subset) {
      System.out.println(i);
    }
  }
}
