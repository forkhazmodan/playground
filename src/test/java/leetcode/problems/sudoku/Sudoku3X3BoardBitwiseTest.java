package leetcode.problems.sudoku;

import problems.leetcode.sudoku.bitwise.Solution;
import org.junit.jupiter.api.Test;

class Sudoku3X3BoardBitwiseTest {

  @Test
  void isValidSudoku() {

    char[][] test1 = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    boolean validSudoku = new Solution().isValidSudoku(test1);

  }

  @Test
  void isValidSudoku2() {

    System.out.println(0/3);
    System.out.println(1/3);
    System.out.println(2/3);

    System.out.println(3/3);
    System.out.println(4/3);
    System.out.println(5/3);

    System.out.println(6/3);
    System.out.println(7/3);
    System.out.println(8/3);



//    System.out.println(3 * (5 / 3) + (5 / 3));
  }
}
