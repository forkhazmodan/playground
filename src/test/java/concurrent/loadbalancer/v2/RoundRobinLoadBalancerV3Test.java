package concurrent.loadbalancer.v2;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundRobinLoadBalancerV3Test {

  private final Map<String, Integer> myMap = new ConcurrentHashMap<>();

  @Test
  void get() {
    LoadBalancer loadBalancer = new RoundRobinLoadBalancerV3(4);
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));
    loadBalancer.register(new BackendInstance("4"));

    Instant start = Instant.now();
    ExecutorService executor = Executors.newFixedThreadPool(40);
    Assertions.assertDoesNotThrow(() -> {
      for (int i = 0; i < 40; i++) {
        executor.execute(() -> {
          BackendInstance backendInstance = loadBalancer.get();
          if (!myMap.containsKey(backendInstance.getIp())) {
            myMap.putIfAbsent(backendInstance.getIp(), 1);
          } else {
            myMap.put(backendInstance.getIp(), myMap.get(backendInstance.getIp()) + 1);
          }
        });
      }
    });

    System.out.println(myMap);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(myMap);
  }
}
