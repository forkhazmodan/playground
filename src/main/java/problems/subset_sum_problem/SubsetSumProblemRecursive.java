package problems.subset_sum_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubsetSumProblemRecursive {

  public static int[] findSubset(int [] subset, int target) {
    int sum = 0;
    for (int i : subset) {
      sum = sum + i;
    }


    List<Integer> collect = Arrays.stream(subset).boxed().collect(Collectors.toList());

    return findSubset(subset, 0, 0, target, new ArrayList<>());
  }

  public static int[] findSubset(int[] subset, int n, int sum, int target, List<Integer> currentNumbers) {

//    System.out.println("COMPUTING: n: " + n + "; " + currentNumbers + "; sum:" + sum);
    if (sum == target && !currentNumbers.isEmpty()) {
      return currentNumbers.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    if (n > subset.length - 1) {
//      System.out.println("SKIPPING: " + "n:" + n + "; " + currentNumbers + "; sum:" + sum);
      return new int[]{};
    }

    ArrayList<Integer> integers = new ArrayList<>(currentNumbers);
    integers.add(subset[n]);

    int[] left = findSubset(subset, n + 1, sum + subset[n], target, integers);
    int[] right = findSubset(subset, n + 1, sum, target, currentNumbers);

    if (left.length > 0) {
      return left;
    } else if (right.length > 0) {
      return right;
    }

    return new int[]{};
  }

}
