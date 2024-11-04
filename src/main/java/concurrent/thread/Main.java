package concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class Main {

  public static void main(String[] args) {
    List<Thread> threads = new ArrayList<>();

    Runnable runnable1 = () -> {

      System.out.println(Thread.currentThread().getName() + " started");
      for (int i = 0; i < 10; i++) {
        try {
          System.out.println(Thread.currentThread().getState().name());
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      System.out.println(Thread.currentThread().getName() + " finished");

    };


    Runnable runnable2 = () -> {

      System.out.println(Thread.currentThread().getName() + " started");
      for (int i = 0; i < 3; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      System.out.println(Thread.currentThread().getName() + " finished");

    };
    Callable<String> callable = new Callable<>() {
      @Override
      public String call() throws Exception {
        return "";
      }
    };

    new Thread(new Thread()).start();

    CompletableFuture.allOf(
        CompletableFuture.runAsync(runnable1),
        CompletableFuture.runAsync(runnable2)
    ).join();

  }

}
