package problems.leetcode.roman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanNumberConverterTest {

  @Test
  void convert() {
    Assertions.assertEquals("I", RomanNumberConverter.convert(1));
    Assertions.assertEquals("IV", RomanNumberConverter.convert(4));
    Assertions.assertEquals("V", RomanNumberConverter.convert(5));
    Assertions.assertEquals("VI", RomanNumberConverter.convert(6));
    Assertions.assertEquals("IX", RomanNumberConverter.convert(9));
    Assertions.assertEquals("XI", RomanNumberConverter.convert(11));
    Assertions.assertEquals("MMMDCCXLIX", RomanNumberConverter.convert(3749));
  }
}
