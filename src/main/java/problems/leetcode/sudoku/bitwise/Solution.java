package problems.leetcode.sudoku.bitwise;

public class Solution {



  public boolean isValidSudoku(char[][] board) {

//    System.out.println(0 * 9 + ('5' - '1'));
//    System.out.println(0 * 9 + ('3' - '1'));
//    System.out.println(('1' - '1'));
//    System.out.println(('2' - '1'));
//    System.out.println(('3' - '1'));
//    System.out.println(0 >> ('4' - '1'));
//    System.out.println(0 >> ('5' - '1'));

    char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int type = 0;
    int rowColBox = 0;

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
//      int bitIdx = type * 9 + (c - '1');
//      if (((rowColBox >> bitIdx) & 1) == 1) {
//        System.out.println(c + "-1");
//      }
//
//      System.out.print(c);
//      System.out.print(":");
//      System.out.print(c-'1');
//      System.out.print(":");
//      System.out.println(rowColBox | (1 << bitIdx));

      rowColBox = validateAndAddCell(c, type, rowColBox);

      System.out.println(rowColBox);
    }

//    char[][] boxes = new char[9][9];
//    char[][] rows = board;
//    char[][] cols = new char[9][9];
//
//    for (int i = 0; i < 9; i++) {
//      String box = "";
//      String col = "";
//      String row = "";
//      for (int j = 0; j < 9; j++) {
//        char c = board[i][j];
//        int boxRow = 3 * (i / 3) + (j / 3);
//        boxes[boxRow][j%9] = c;
//        cols[i][j%9] = board[j][i];
//        box = box + "" + c;
//        row = row + "" + c;
//        col = col + "" + board[j][i];
//      }
//
//      System.out.println(col);
////      System.out.println("");
////      System.out.println(col);
////      System.out.println("");
////      System.out.println(box);
//      box = "";
//      row = "";
//      box = "";
//    }

    //53..7....
    //6..195...
    //.98....6.
    //8...6...3
    //4..8.3..1
    //7...2...6
    //.6....28.
    //...419..5
    //....8..79


    return false;
  }

  public int validateAndAddCell(char c, int type, int rowColBox) {
    if (c == '.') {
      return rowColBox;
    }
    if (c < '1' || c > '9') {
      return -1;
    }

    int bitIdx = type * 9 + (c - '1');
    System.out.print("(" + rowColBox + " >> " + bitIdx +")=" + (rowColBox >> bitIdx));
    System.out.println(" -> (" + print(rowColBox) + " >> " + print(bitIdx) +")=" + (rowColBox >> bitIdx));
    System.out.print("((" + rowColBox + " >> " + bitIdx +") & 1)=" + ((rowColBox >> bitIdx) & 1));
    System.out.println(" -> ((" + print(rowColBox) + " >> " + print(bitIdx) +") & 1)=" + ((rowColBox >> bitIdx) & 1));
    System.out.println();
    System.out.println(rowColBox + " | (1 << " + bitIdx + ") = " + (rowColBox | (1 << bitIdx)));
    System.out.println(print(rowColBox) + " | (1 << " + print(bitIdx)  + ") = " + print(rowColBox | (1 << bitIdx)));
    if (((rowColBox >> bitIdx) & 1) == 1) {
      return -1;
    }

    return rowColBox | (1 << bitIdx);
  }


  public String print(int i) {
    String replace = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
    return replace;
  }


  //(0 >> 0)=0 -> (0000000000000000 >> 0000000000000000)=0
  //((0 >> 0) & 1)=0 -> ((0000000000000000 >> 0000000000000000) & 1)=0
  //1
  //(1 >> 1)=0 -> (0000000000000001 >> 0000000000000001)=0
  //((1 >> 1) & 1)=0 -> ((0000000000000001 >> 0000000000000001) & 1)=0
  //3
  //(3 >> 2)=0 -> (0000000000000011 >> 0000000000000010)=0
  //((3 >> 2) & 1)=0 -> ((0000000000000011 >> 0000000000000010) & 1)=0
  //7
  //(7 >> 3)=0 -> (0000000000000111 >> 0000000000000011)=0
  //((7 >> 3) & 1)=0 -> ((0000000000000111 >> 0000000000000011) & 1)=0
  //15
  //(15 >> 4)=0 -> (0000000000001111 >> 0000000000000100)=0
  //((15 >> 4) & 1)=0 -> ((0000000000001111 >> 0000000000000100) & 1)=0
  //31
  //(31 >> 5)=0 -> (0000000000011111 >> 0000000000000101)=0
  //((31 >> 5) & 1)=0 -> ((0000000000011111 >> 0000000000000101) & 1)=0
  //63
  //(63 >> 6)=0 -> (0000000000111111 >> 0000000000000110)=0
  //((63 >> 6) & 1)=0 -> ((0000000000111111 >> 0000000000000110) & 1)=0
  //127
  //(127 >> 8)=0 -> (0000000001111111 >> 0000000000001000)=0
  //((127 >> 8) & 1)=0 -> ((0000000001111111 >> 0000000000001000) & 1)=0
  //383
  //(383 >> 8)=1 -> (0000000101111111 >> 0000000000001000)=1
  //((383 >> 8) & 1)=1 -> ((0000000101111111 >> 0000000000001000) & 1)=1
  //-1


  //(0 >> 0)=0 -> (0000000000000000 >> 0000000000000000)=0
  //((0 >> 0) & 1)=0 -> ((0000000000000000 >> 0000000000000000) & 1)=0
  //1
  //(1 >> 1)=0 -> (0000000000000001 >> 0000000000000001)=0
  //((1 >> 1) & 1)=0 -> ((0000000000000001 >> 0000000000000001) & 1)=0
  //3
  //(3 >> 2)=0 -> (0000000000000011 >> 0000000000000010)=0
  //((3 >> 2) & 1)=0 -> ((0000000000000011 >> 0000000000000010) & 1)=0
  //7
  //(7 >> 3)=0 -> (0000000000000111 >> 0000000000000011)=0
  //((7 >> 3) & 1)=0 -> ((0000000000000111 >> 0000000000000011) & 1)=0
  //15
  //(15 >> 4)=0 -> (0000000000001111 >> 0000000000000100)=0
  //((15 >> 4) & 1)=0 -> ((0000000000001111 >> 0000000000000100) & 1)=0
  //31
  //(31 >> 5)=0 -> (0000000000011111 >> 0000000000000101)=0
  //((31 >> 5) & 1)=0 -> ((0000000000011111 >> 0000000000000101) & 1)=0
  //63
  //(63 >> 6)=0 -> (0000000000111111 >> 0000000000000110)=0
  //((63 >> 6) & 1)=0 -> ((0000000000111111 >> 0000000000000110) & 1)=0
  //127
  //(127 >> 7)=0 -> (0000000001111111 >> 0000000000000111)=0
  //((127 >> 7) & 1)=0 -> ((0000000001111111 >> 0000000000000111) & 1)=0
  //255
  //(255 >> 8)=0 -> (0000000011111111 >> 0000000000001000)=0
  //((255 >> 8) & 1)=0 -> ((0000000011111111 >> 0000000000001000) & 1)=0
  //511
}
