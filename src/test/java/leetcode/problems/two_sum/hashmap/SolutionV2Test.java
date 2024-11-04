package leetcode.problems.two_sum.hashmap;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import problems.leetcode.two_sum.hashmap.SolutionV2;

public class SolutionV2Test {

  @Test
  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @BenchmarkMode(Mode.SingleShotTime)
  public void twoSum() {
    twoSumBench();
//    Assertions.assertArrayEquals(new int[]{},     SolutionV2.twoSum(new int[]{-6, 16}, 9));
//    Assertions.assertArrayEquals(new int[]{0, 1}, SolutionV2.twoSum(new int[]{-7, 16}, 9));
    Assertions.assertArrayEquals(new int[]{0, 1}, SolutionV2.twoSum(new int[]{2, 7, 11, 15}, 9));
//    Assertions.assertArrayEquals(new int[]{1, 2}, SolutionV2.twoSum(new int[]{3, 2, 4}, 6));
//    Assertions.assertArrayEquals(new int[]{0, 1}, SolutionV2.twoSum(new int[]{3, 3}, 6));
  }

  @Benchmark
//  @Fork(value = 1, warmups = 2)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @BenchmarkMode(Mode.SingleShotTime)
  public void twoSumBench() {
    SolutionV2.twoSum(new int[]{2, 7, 11, 15}, 9);
  }


}
