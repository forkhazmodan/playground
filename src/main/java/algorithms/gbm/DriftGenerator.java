package algorithms.gbm;

import java.util.Random;

public class DriftGenerator {

  private final Random random;

  public DriftGenerator(Random random) {
    this.random = random;
  }

  public double generateDrift(int trend) {
    return trend * (0.00005 + random.nextDouble() * 0.0002);
  }
}
