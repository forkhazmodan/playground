package concurrent.loadbalancer.v2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancerV3 extends LoadBalancer {

  private final static Integer DEFAULT_LOAD_BALANCER_SIZE = 10;
  private final Integer size;
  private final List<BackendInstance> backendInstancesList;

  private final AtomicInteger counter;

  public RoundRobinLoadBalancerV3(Integer size) {
    this.size = size == null ? DEFAULT_LOAD_BALANCER_SIZE : size;
    this.backendInstancesList = new CopyOnWriteArrayList<>();

    counter = new AtomicInteger(0);
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
    counter.compareAndSet(backendInstancesList.size() * 10, 0);
    return backendInstancesList.get(counter.getAndIncrement() % backendInstancesList.size());
  }
}
