package concurrent.loadbalancer.v3;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinBalancerStrategy implements ILoadBalancerStrategy {
  private int counter;

  @Override
  synchronized public BackendInstance selectFrom(List<BackendInstance> instances) {
    BackendInstance backendInstance = instances.get(counter);
    counter++;
    if (counter == instances.size()) {
      counter = 0;
    }
    return backendInstance;
  }
}
