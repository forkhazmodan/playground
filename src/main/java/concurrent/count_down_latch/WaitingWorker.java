package concurrent.count_down_latch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WaitingWorker implements Runnable {

  private List<String> outputScraper;
  private CountDownLatch readyThreadCounter;
  private CountDownLatch callingThreadBlocker;
  private CountDownLatch completedThreadCounter;

  public WaitingWorker(
      List<String> outputScraper,
      CountDownLatch readyThreadCounter,
      CountDownLatch callingThreadBlocker,
      CountDownLatch completedThreadCounter) {

    this.outputScraper = outputScraper;
    this.readyThreadCounter = readyThreadCounter;
    this.callingThreadBlocker = callingThreadBlocker;
    this.completedThreadCounter = completedThreadCounter;
  }

  @Override
  public void run() {
    readyThreadCounter.countDown();
    try {
      callingThreadBlocker.await();
      Thread.sleep(1000);
      System.out.println("Counted down");
      outputScraper.add("Counted down");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      completedThreadCounter.countDown();
    }
  }
}
