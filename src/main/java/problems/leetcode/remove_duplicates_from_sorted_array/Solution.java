package problems.leetcode.remove_duplicates_from_sorted_array;
class Solution {
  public int removeDuplicates(int[] nums) {

    int i = 0;
    int j = 0;

    while(nums.length > j) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }

      j++;

    }

    return i + 1;
  }
}
