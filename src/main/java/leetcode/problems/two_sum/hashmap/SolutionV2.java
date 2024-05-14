package leetcode.problems.two_sum.hashmap;

import java.util.HashMap;

public class SolutionV2 {

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numMap = new HashMap<>();
    if (nums.length < 2) {
      return new int[]{};
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (numMap.containsKey(complement)) {
        return new int[]{numMap.get(complement), i};
      }
      numMap.put(nums[i], i);
    }

    return new int[]{};
  }

}