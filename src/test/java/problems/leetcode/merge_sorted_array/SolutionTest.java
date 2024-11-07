package problems.leetcode.merge_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void merge() {

        Solution solution = new Solution();
        solution.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,4,5}, 3);
    }
}