package concurrent.loadbalancer.v1;

import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;

public class Main {

  public static void main(String[] args) {

    LoadBalancer loadBalancer = new LoadBalancer();

    Scanner in = new Scanner(System.in);
    while (true) {
      if (!in.hasNextLine()) {
        continue;
      }

      String line = in.nextLine();

      String[] split = line.split(",");

      try {
        for (String s : split) {
          Request request = new Request(s);
          loadBalancer.delegate(request);
          System.out.println("Request: " + request.getName());
        }
      } catch (RejectedExecutionException e) {
        e.printStackTrace();
      }


    }
  }
}
