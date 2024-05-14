package concurrent.loadbalancer.v2;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class WeightLoadBalancer extends LoadBalancer {

  private final Map<String, BackendInstance> instances = new ConcurrentHashMap<>();

  private final Integer size;

  public WeightLoadBalancer(Integer size) {
    this.size = size;
  }

  @Override
  public void register(BackendInstance backendInstance) {
    if (instances.size() >= size) {
      return;
    }

    instances.put(backendInstance.getIp(), backendInstance);
  }

  public void register(BackendInstance backendInstance, Integer weight) {
    for (int i = 0; i < weight; i++) {
      register(backendInstance);
    }
  }

  @Override
  public BackendInstance get() {
    List<String> collect = instances.keySet().stream().collect(Collectors.toList());
    String s = collect.get(ThreadLocalRandom.current().nextInt());
    return instances.get(s);
  }
}
