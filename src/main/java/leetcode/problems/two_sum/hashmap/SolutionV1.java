package leetcode.problems.two_sum.hashmap;

import java.util.HashMap;

public class SolutionV1 {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int [] output = new int[2];
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      Integer j = map.get(target - nums[i]);
      if (j != null && i != j) {
        output[0] = i;
        output[1] = j;
        break;
      }
    }

    return output;
  }
}
