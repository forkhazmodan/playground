package concurrent.loadbalancer.v1;

public class Entrypoint {

  private LoadBalancer loadBalancer;

  public Entrypoint(LoadBalancer loadBalancer) {
    this.loadBalancer = loadBalancer;
  }

  public void handle(Request request) {
    loadBalancer.delegate(request);
  }

}
