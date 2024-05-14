package concurrent.loadbalancer.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LoadBalancer {

  private final ExecutorService executorService;

  public LoadBalancer() {
    this.executorService = new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
  }

  public void delegate(Runnable runnable) {
    executorService.execute(runnable);
  }
}
