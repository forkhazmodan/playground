package problems.leetcode.majority_element;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(3/2);
        System.out.println(4/2);
//        int i = new Solution().majorityElement(new int[]{1, 10, 3, 2, 2, 2, 2});
//        int i2 = new Solution().majorityElement(new int[]{1, 10, 3, 4, 2, 2, 2, 2});
    }

    public Solution() {
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length / 2;
        int last = nums.length - 1;

        if (nums[mid] == nums[last]) {
            return nums[mid];
        }

        return 0;
    }
}
