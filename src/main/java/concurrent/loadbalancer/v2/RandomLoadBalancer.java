package concurrent.loadbalancer.v2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLoadBalancer extends LoadBalancer {

  private final static Integer DEFAULT_SIZE = 10;
  private final Integer size;
  private final List<BackendInstance> backendInstancesList;

  public RandomLoadBalancer(Integer size) {
    this.size = size == null ? DEFAULT_SIZE : size;
    this.backendInstancesList = new CopyOnWriteArrayList<>();
  }

  public void register(BackendInstance backendInstance) {
    if (backendInstancesList.contains(backendInstance)) {
      return;
    }
    if (backendInstancesList.size() >= size) {
      return;
    }

    backendInstancesList.add(backendInstance);
  }

  public BackendInstance get() {
    return backendInstancesList.get(ThreadLocalRandom.current().nextInt(0, backendInstancesList.size()));
  }

  public List<BackendInstance> getBackendInstancesList() {
    return backendInstancesList;
  }
}
