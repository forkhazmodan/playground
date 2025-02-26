package algorithms.gbm;

import java.util.Random;

public class Main {

  public static void main(String[] args) {
    StockPriceGenerator stockPriceGenerator = new StockPriceGenerator(100.0, 0.001, 0.01);
    DriftGenerator driftGenerator = new DriftGenerator(new Random());
    TrendGenerator trendGenerator = new TrendGenerator(new Random());

    for (int i = 0; i < 300; i++) {

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      stockPriceGenerator.setDrift(driftGenerator.generateDrift(trendGenerator.getTrend()));
      System.out.println(stockPriceGenerator.generatePrice());
    }

  }

}
