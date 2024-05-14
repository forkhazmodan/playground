package concurrent.loadbalancer.v1;

import java.util.UUID;

public class Request implements Runnable {

  private final UUID uuid = UUID.randomUUID();
  private final String name;

  public Request(String name) {
    this.name = name;
  }

  public String getName() {
    return uuid.toString() + " - " + name;
  }

  @Override
  public void run() {
    System.out.println("Started:" + this.name);
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("Finished:" + this.name);
  }
}
