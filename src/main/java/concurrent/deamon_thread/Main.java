package concurrent.deamon_thread;

public class Main {

  public static void main(String[] args) {
    Thread thread1 = new Thread();
    Thread thread2 = new Thread();
  }

  class DeamonHelper implements Runnable {

    @Override
    public void run() {
      int count = 0;
      while (count < 500) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        count++;
        System.out.println("DeamonHelper is running...");
      }
    }
  }

}
