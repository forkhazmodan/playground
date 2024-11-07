package problems.leetcode.single_numbers_ii;


import org.apache.commons.lang3.StringUtils;

public class Solution {
  public static int singleNumber(int[] nums) {

    for (int num : nums) {
      System.out.println(getBinary(num));
    }
    int result = nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
      int temp = result;
      result = result ^ nums[i+1];
      System.out.println(getBinary(temp) + " ^ " + getBinary(nums[i + 1]) + " = " + getBinary(result));
      System.out.println(temp + " ^ " + nums[i + 1] + " = " + result);
    }

//
//    printBinary(0);
//    printBinary(1);
//    printBinary(2);
//    printBinary(3);
//    printBinary(4);
//    printBinary(5);
//    printBinary(6);
//    printBinary(7);
//    printBinary(8);
//    printBinary(99);
//
//    System.out.println("AND");
//    printBinary(2 & 2);
//    printBinary(2 & 3);
//    System.out.println("OR");
//    printBinary(2 | 2);
//    printBinary(2 | 3);
//    System.out.println("^");
//    printBinary(0);
//    printBinary(0);
//    printBinary(0 ^ 3);
//    printBinary((0 ^ 3) ^ 2);

    return result;
  }

  public static String getBinary(int n) {
    return StringUtils.leftPad(Integer.toBinaryString(n), 8, "0");
  }

  public static void printBinary(int n) {
    System.out.println(getBinary(n));
  }

}
