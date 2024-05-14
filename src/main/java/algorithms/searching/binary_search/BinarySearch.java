package algorithms.searching.binary_search;

public class BinarySearch {
  public static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid;

    while(low <= high) {
      mid = low + (high - low) / 2;

      if (target == nums[mid]) {
        return mid;
      }

      if (target < nums[mid]) {
        high = mid - 1;
      } else if (target > nums[mid]) {
        low = mid + 1;
      }
    }

    return -1;
  }
}
