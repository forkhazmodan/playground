package concurrent.count_down_latch;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
  private List<String> outputScraper;
  private CountDownLatch countDownLatch;

  public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
    this.outputScraper = outputScraper;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Doing some work...");
    outputScraper.add("Counted down" + Instant.now().toEpochMilli());
    countDownLatch.countDown();
  }
}
