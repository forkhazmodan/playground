package concurrent.loadbalancer.v3;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLoadBalancerStrategy implements ILoadBalancerStrategy {

  @Override
  public BackendInstance selectFrom(List<BackendInstance> instances) {
    int i = ThreadLocalRandom.current().nextInt(0, instances.size());
    return instances.get(i);
  }
}
