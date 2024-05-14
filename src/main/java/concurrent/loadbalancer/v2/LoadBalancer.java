package concurrent.loadbalancer.v2;

abstract public class LoadBalancer {

  public abstract void register(BackendInstance backendInstance);

  public abstract BackendInstance get();
}
