package concurrent.loadbalancer.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RoundRobinLoadBalancerV1 extends LoadBalancer {

  private final static Integer DEFAULT_SIZE = 10;
  private final Integer size;
  private final Map<String, BackendInstance> instances = new ConcurrentHashMap<>();

  public RoundRobinLoadBalancerV1(Integer size) {
    this.size = size == null ? DEFAULT_SIZE : size;
  }

  @Override
  public void register(BackendInstance backendInstance) {
    if (instances.containsValue(backendInstance)) {
      return;
    }
    if (instances.size() >= this.size) {
      return;
    }

    instances.put(backendInstance.getIp(), backendInstance);
  }

  @Override
  public BackendInstance get() {
    List<String> instanceKeys = new ArrayList<>(instances.keySet());
    String randomAddress = instances.get(ThreadLocalRandom.current().nextInt(instanceKeys.size())).getIp();
    return instances.get(randomAddress);
  }
}
