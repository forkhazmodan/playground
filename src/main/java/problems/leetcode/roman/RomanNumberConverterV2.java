package problems.leetcode.roman;

import java.util.Map;
import java.util.TreeMap;

public class RomanNumberConverterV2 {

      public static String convert(int number) {
        return convert(number, "");
      }

      public static String convert(int number, String buffer) {

        if (number >= 1000) { return convert(number - 1000, buffer + "M"); }
        if (number >= 500)  { return convert(number - 500,  buffer + "D"); }
        if (number >= 400)  { return convert(number - 400,  buffer + "CD"); }
        if (number >= 100)  { return convert(number - 100,  buffer + "C"); }
        if (number >= 90)   { return convert(number - 90,   buffer + "XC"); }
        if (number >= 50)   { return convert(number - 90,   buffer + "L"); }
        if (number >= 40)   { return convert(number - 40,   buffer + "XL"); }
        if (number >= 10)   { return convert(number - 10,   buffer + "X"); }
        if (number >= 9)    { return convert(number - 9,    buffer + "IX"); }
        if (number >= 5)    { return convert(number - 5,    buffer + "V"); }
        if (number >= 4)    { return convert(number - 4,    buffer + "IV"); }
        if (number >= 1)    { return convert(number - 1,    buffer + "I"); }

        return buffer;
      }
}
