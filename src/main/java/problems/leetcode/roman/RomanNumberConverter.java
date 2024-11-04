package problems.leetcode.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumberConverter {

      public static final Map<Integer, String> TABLE = new TreeMap<>();

      static {
        TABLE.put(1000, "M");
        TABLE.put(500, "D");
        TABLE.put(400, "CD");
        TABLE.put(100, "C");
        TABLE.put(90, "XC");
        TABLE.put(50, "L");
        TABLE.put(40, "XL");
        TABLE.put(10, "X");
        TABLE.put(9, "IX");
        TABLE.put(5, "V");
        TABLE.put(4, "IV");
        TABLE.put(1, "I");
      }

      public static String convert(int number) {

        if (number <= 0) {
          return "";
        }
        int key = 0;
        for (Integer i : TABLE.keySet()) {
          if (i > number) {
            break;
          }
          key = i;
        }

        if (key != 0) {
          return TABLE.get(key) + convert(number - key);
        } else {
          return "";
        }
      }



}
