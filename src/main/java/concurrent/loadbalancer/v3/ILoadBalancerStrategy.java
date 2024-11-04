package concurrent.loadbalancer.v3;

import java.util.List;

public interface ILoadBalancerStrategy {
  BackendInstance selectFrom(List<BackendInstance> instances);
}
