package concurrent.loadbalancer.v3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadBalancer {

  private List<BackendInstance> instanceList;
  private ILoadBalancerStrategy loadBalancerStrategy;

  public LoadBalancer(ILoadBalancerStrategy defaultStrategy) {
    this.instanceList = new CopyOnWriteArrayList<>();
    this.loadBalancerStrategy = defaultStrategy;
  }

  public List<BackendInstance> getInstanceList() {
    return instanceList;
  }

  public void setStrategy(ILoadBalancerStrategy loadBalancerStrategy) {
    this.loadBalancerStrategy = loadBalancerStrategy;
  }

  public void register(BackendInstance backendInstance) {
    if (null == backendInstance) {
      return;
    }

    if (instanceList.contains(backendInstance)) {
      throw new RuntimeException("Instance already exists: " + backendInstance.getIp());
    }

    instanceList.addAll(Stream.generate(() -> backendInstance)
        .limit(backendInstance.getWeight())
        .collect(Collectors.toList())
    );
  }

  public void remove(BackendInstance backendInstance) {
    if (null == backendInstance) {
      throw new IllegalArgumentException("backendInstance is null");
    }

    if (backendInstance.getIp() == null) {
      throw new IllegalArgumentException("backendInstance.getIp is null");
    }

    instanceList.removeIf(v -> v.getIp().equals(backendInstance.getIp()));
  }

  public BackendInstance get() {
    return this.loadBalancerStrategy.selectFrom(instanceList);
  }
}
