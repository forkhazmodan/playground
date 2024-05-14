package concurrent.loadbalancer.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoadBalancerTest {


  @Test
  void register() {
    RandomLoadBalancer loadBalancer = new RandomLoadBalancer(10);
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("1"));

    Assertions.assertEquals(3, loadBalancer.getBackendInstancesList().size());
  }

  @Test
  void get() {
  }

  @Test
  void testGet() {

    RandomLoadBalancer loadBalancer = new RandomLoadBalancer(10);
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));

    ExecutorService executor = Executors.newFixedThreadPool(100);
    Assertions.assertDoesNotThrow(() -> {
      for (int i = 0; i < 100; i++) {
        executor.execute(() -> {
          System.out.println(loadBalancer.get());
        });
      }
    });


  }
}
