package problems.leetcode.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanNumberConverterV2Test {

  @Test
  void convert() {
    Assertions.assertEquals("I", RomanNumberConverterV2.convert(1));
    Assertions.assertEquals("IV", RomanNumberConverterV2.convert(4));
    Assertions.assertEquals("V", RomanNumberConverterV2.convert(5));
    Assertions.assertEquals("VI", RomanNumberConverterV2.convert(6));
    Assertions.assertEquals("IX", RomanNumberConverterV2.convert(9));
    Assertions.assertEquals("XI", RomanNumberConverterV2.convert(11));
    Assertions.assertEquals("MMMDCCXLIX", RomanNumberConverterV2.convert(3749));
  }
}
