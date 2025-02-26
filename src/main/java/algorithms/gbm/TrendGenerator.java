package algorithms.gbm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class TrendGenerator {

  private Instant nextTrendCheck = Instant.now().plus(10, ChronoUnit.SECONDS);
  private int trend = 1;

  private final Random random;

  public TrendGenerator(Random random) {
    this.random = random;
  }

  public int getTrend() {
    attemptToChangeTrend();
    return trend;
  }

  public void setNextTrendCheck(Instant nextTrendCheck) {
    if (Instant.now().isAfter(nextTrendCheck)) {
      throw new IllegalArgumentException("The next trend check is in the past");
    }

    this.nextTrendCheck = nextTrendCheck;
    System.out.println("Current time: " + Instant.now());
    System.out.println("Next trend check: " + nextTrendCheck);
  }

  private void attemptToChangeTrend() {
    if (nextTrendCheck.isBefore(Instant.now())) {
      setNextTrendCheck(generateNextTrendCheck());

      int previousTrend = trend;
      trend = random.nextBoolean() ? 1 : -1;

      if (previousTrend != trend) {
        System.out.println("Trend has changed from: " + previousTrend + " to " + trend);
      }
    }
  }

  private Instant generateNextTrendCheck() {
    return Instant.now().plus(5 + random.nextInt(25), ChronoUnit.MINUTES);
  }
}
