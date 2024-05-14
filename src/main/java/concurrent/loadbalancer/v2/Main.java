package concurrent.loadbalancer.v2;

public class Main {

  public static void main(String[] args) {
    RandomLoadBalancer loadBalancer = new RandomLoadBalancer(10);

    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("1"));
    loadBalancer.register(new BackendInstance("2"));
    loadBalancer.register(new BackendInstance("3"));
    loadBalancer.register(new BackendInstance("4"));
    loadBalancer.register(new BackendInstance("5"));
    loadBalancer.register(new BackendInstance("6"));
    loadBalancer.register(new BackendInstance("7"));
    loadBalancer.register(new BackendInstance("8"));
    loadBalancer.register(new BackendInstance("9"));
    loadBalancer.register(new BackendInstance("10"));
    loadBalancer.register(new BackendInstance("11"));

    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
    System.out.println(loadBalancer.get());
  }

}
