package problems.leetcode.iii_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int i = 0;
    int j = i + 1;
    int k = nums.length - 1;

    while (i != k) {

      if (nums[j] == nums[j-1]) {
        j++;
        continue;
      }

      if (nums[i] == nums[i-1]) {
        i++;
        continue;
      }

      if (j>=k) {
        i++;
        j = i + 1;
        continue;
      }

      int sum = nums[i] + nums[j] + nums[k];

      if (sum == 0) {
        result.add(List.of(nums[i], nums[j], nums[k]));
        j++;
      } else if(sum > 0) {
        k--;
      } else if (sum < 0) {
        j++;
      }
    }

    //-1,0,1,2,-1,-4
    // i j         k

    //-4,-1,-1,0,1,2
    // i j         k

    //-4,-1,-1,0,1,2
    // i j         k


    //-1,0,1,2,3,4
    // i j       k


    //-1,0,1,2,3,4
    // i j k


    // [[-2, -1, 3],[-2, 0, 2],[-1,0,1]]
    // =====
    //-2,-1,0,1,2,3,4 -> k -= 1
    // i  j         k

    //-2,-1,0,1,2,3,4 -> [-2, -1, 3]
    // i  j       k

    //-2,-1,0,1,2,3,4 -> j += 1
    // i  j     k

    //-2,-1,0,1,2,3,4 -> [-2, 0, 2]
    // i    j   k

    //-2,-1,0,1,2,3,4 -> k -= 1
    // i    j k

    //-2,-1,0,1,2,3,4 -> [-2, 0, 2]
    // i    j k


    return result;
  }

}
