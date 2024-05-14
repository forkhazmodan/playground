package concurrent.loadbalancer.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundRobinLoadBalancerV1Test {

  @Test
  public void get() {
    LoadBalancer loadBalancer = new RoundRobinLoadBalancerV1(4);
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));
    loadBalancer.register(new BackendInstance("4"));

    ExecutorService executor = Executors.newFixedThreadPool(10000);
    Assertions.assertDoesNotThrow(() -> {
      for (int i = 0; i < 10000; i++) {
        executor.execute(() -> {
//          System.out.println(Thread.currentThread().getId() + ": " + loadBalancer.get());
        });
      }
    });
  }
}
