package concurrent.loadbalancer.v2;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundRobinLoadBalancerV2Test {

  @Test
  void get() {
    LoadBalancer loadBalancer = new RoundRobinLoadBalancerV2(4);
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));
    loadBalancer.register(new BackendInstance("4"));

    Instant start = Instant.now();
    ExecutorService executor = Executors.newFixedThreadPool(10000);
    Assertions.assertDoesNotThrow(() -> {
      for (int i = 0; i < 10000; i++) {
        executor.execute(() -> {
//          System.out.println(Thread.currentThread().getId() + ": " + loadBalancer.get());
        });
      }
    });

    Instant end = Instant.now();
    System.out.println("time: " + (end.toEpochMilli() - start.toEpochMilli()));
  }
}
