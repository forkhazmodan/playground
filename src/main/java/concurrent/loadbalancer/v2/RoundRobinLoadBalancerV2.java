package concurrent.loadbalancer.v2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancerV2 extends LoadBalancer {

  private final static Integer DEFAULT_LOAD_BALANCER_SIZE = 10;
  private final Integer size;
  private final List<BackendInstance> backendInstancesList;

  int counter;
  ReentrantLock lock;

  public RoundRobinLoadBalancerV2(Integer size) {
    this.size = size == null ? DEFAULT_LOAD_BALANCER_SIZE : size;
    this.backendInstancesList = new CopyOnWriteArrayList<>();
    lock = new ReentrantLock();
  }

  @Override
  public void register(BackendInstance backendInstance) {
    if (backendInstancesList.contains(backendInstance)) {
      return;
    }
    if (backendInstancesList.size() >= this.size) {
      return;
    }

    backendInstancesList.add(backendInstance);
  }

  @Override
  public BackendInstance get() {
    lock.lock();
    try {
      BackendInstance backendInstance = backendInstancesList.get(counter);
      counter += 1;
      if (counter == backendInstancesList.size()) {
        counter = 0;
      }
      return backendInstance;
    } finally {
      lock.unlock();
    }
  }
}
