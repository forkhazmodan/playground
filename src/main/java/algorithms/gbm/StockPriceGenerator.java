package algorithms.gbm;

import java.util.Random;

public class StockPriceGenerator {

  private Random random = new Random();
  private double initialPrice = 100.0; // Starting stock price
  private double drift = 0.0001;       // Average trend per second (e.g., 0.01% upward per second)
  private double volatility = 0.01;   // Volatility (standard deviation of returns per second)
  private double currentPrice;

  public StockPriceGenerator(double initialPrice, double drift, double volatility) {
    this.initialPrice = initialPrice;
    this.currentPrice = initialPrice;
    this.drift = drift;
    this.volatility = volatility;
  }

  public void setInitialPrice(double initialPrice) {
    this.initialPrice = initialPrice;
  }

  public void setDrift(double drift) {
    this.drift = drift;
  }

  public void setVolatility(double volatility) {
    this.volatility = volatility;
  }

  public double generatePrice() {
    double randomShock = random.nextGaussian();

    // Calculate the next price using Geometric Brownian Motion formula
    double change = drift * this.currentPrice + volatility * this.currentPrice * randomShock;
    double nextPrice = this.currentPrice + change;

    // Avoid negative stock prices
    if (nextPrice < 0) nextPrice = 0.01;

    this.currentPrice = nextPrice;

    return nextPrice;
  }


}
