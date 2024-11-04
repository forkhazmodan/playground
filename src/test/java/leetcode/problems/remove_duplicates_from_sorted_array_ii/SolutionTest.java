package leetcode.problems.remove_duplicates_from_sorted_array_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.leetcode.remove_duplicates_from_sorted_array_ii.Solution;

class SolutionTest {

  @Test
  void removeDuplicates_case1() {
    Solution solution = new Solution();
    int[] nums = {1, 1, 1, 2, 2, 3};
    int i = solution.removeDuplicates(nums);
    Assertions.assertEquals(5, i);
    //[1,1,2,2,3,_]
    Assertions.assertEquals(1, nums[0]);
    Assertions.assertEquals(1, nums[1]);
    Assertions.assertEquals(2, nums[2]);
    Assertions.assertEquals(2, nums[3]);
    Assertions.assertEquals(3, nums[4]);
  }

  @Test
  void removeDuplicates_case2() {
    Solution solution = new Solution();
    int[] nums = {0,0,1,1,1,1,2,3,3};
    int i = solution.removeDuplicates(nums);
    Assertions.assertEquals(7, i);
    //[0,0,1,1,2,3,3,_,_]
    Assertions.assertEquals(0, nums[0]);
    Assertions.assertEquals(0, nums[1]);
    Assertions.assertEquals(1, nums[2]);
    Assertions.assertEquals(1, nums[3]);
    Assertions.assertEquals(2, nums[4]);
    Assertions.assertEquals(3, nums[5]);
    Assertions.assertEquals(3, nums[6]);
  }


  @Test
  void removeDuplicates_case3() {
    Solution solution = new Solution();
    int[] nums = {1,1,1};
    int i = solution.removeDuplicates(nums);
    Assertions.assertEquals(2, i);
    //[0,0,1,1,2,3,3,_,_]
    Assertions.assertEquals(1, nums[0]);
    Assertions.assertEquals(1, nums[1]);
  }
}
