package concurrent.loadbalancer.v3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

public class LoadBalancerTest {

  @Test
  void setStrategy() throws InterruptedException {
//    LoadBalancer loadBalancer = new LoadBalancer(new RandomLoadBalancerStrategy());
    LoadBalancer loadBalancer = new LoadBalancer(new RoundRobinBalancerStrategy());
    loadBalancer.register(new BackendInstance("1", 1));
    loadBalancer.register(new BackendInstance("2", 1));
    loadBalancer.register(new BackendInstance("3", 2));
    loadBalancer.register(null);

    Map<String, AtomicInteger> results = new ConcurrentHashMap<>();
    ExecutorService executorService = Executors.newFixedThreadPool(5000);
    CountDownLatch countDownLatch = new CountDownLatch(40000);

    for (int i = 0; i < 40000; i++) {
      executorService.execute(() -> {
        BackendInstance backendInstance1 = loadBalancer.get();
        if (results.containsKey(backendInstance1.getIp())) {
          results.get(backendInstance1.getIp()).incrementAndGet();
        } else {
          results.put(backendInstance1.getIp(), new AtomicInteger(1));
        }
        countDownLatch.countDown();
      });
    }
    countDownLatch.await();
//    System.out.println(results);
    Assertions.assertEquals(10000, results.get("1").get());
    Assertions.assertEquals(10000, results.get("2").get());
    Assertions.assertEquals(20000, results.get("3").get());
  }

  @Test
  void register() {
    LoadBalancer loadBalancer = new LoadBalancer(new RoundRobinBalancerStrategy());
    BackendInstance backendInstance = new BackendInstance("1", 1);
    BackendInstance backendInstance1 = new BackendInstance("2", 10);
    loadBalancer.register(new BackendInstance("1", 1));
    loadBalancer.register(new BackendInstance("2", 10));

    loadBalancer.remove(backendInstance1);

    System.out.println(loadBalancer.getInstanceList());
  }

  @Test
  void remove() {

  }

  @Test
  void get() {
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @BenchmarkMode(Mode.SingleShotTime)
  public void setStrategyBenchmark () {
//    this.setStrategy();
  }
}
