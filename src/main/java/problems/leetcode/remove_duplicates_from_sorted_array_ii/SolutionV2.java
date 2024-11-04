package problems.leetcode.remove_duplicates_from_sorted_array_ii;

public class SolutionV2 {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if(n<=2){
      return n;
    }

    int j = 2;
    for(int i=2; i<n; i++){
      if(nums[i] != nums[j-2]){
        nums[j] = nums[i];
        j++;
      }
    }
    return j;
  }

}

//
