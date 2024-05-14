package custom.count_down_latch;

import static org.junit.jupiter.api.Assertions.*;

import concurrent.count_down_latch.Worker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WorkerTest {
  @Test
  public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion()
      throws InterruptedException {

    List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
    CountDownLatch countDownLatch = new CountDownLatch(5);
    List<Thread> workers = Stream
        .generate(() -> new Thread(new Worker(outputScraper, countDownLatch)))
        .limit(5)
        .collect(Collectors.toList());

    workers.forEach(Thread::start);
    countDownLatch.await();
    outputScraper.add("Latch released");

    assertEquals(outputScraper, List.of(
        "Counted down",
        "Counted down",
        "Counted down",
        "Counted down",
        "Counted down",
        "Latch released")
    );
  }
}
