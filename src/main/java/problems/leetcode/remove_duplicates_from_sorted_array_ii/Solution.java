package problems.leetcode.remove_duplicates_from_sorted_array_ii;

public class Solution {
  public int removeDuplicates(int[] nums) {
    int result = nums.length;

    int l = 0;
    int m = 1;
    int r = 2;

    while (r <= result - 1) {
      int left = nums[l];
      int middle = nums[m];
      int right = nums[r];

      if (left == middle && middle == right) {
        for(int i=r; i < nums.length -1; i++ ) {
          nums[i] = nums[i + 1];
        }
        result--;
      } else {
        l++;
        m++;
        r++;
      }
    }

    return result;
  }
}
