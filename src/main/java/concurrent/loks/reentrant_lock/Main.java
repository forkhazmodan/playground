package concurrent.loks.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main implements Runnable {
  static int counter = 1; // a global counter

  static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy

  static void incrementCounter(){
    counterLock.lock();

    // Always good practice to enclose locks in a try-finally block
    try{
      System.out.println(Thread.currentThread().getName() + ": " + counter);
      counter++;
    }finally{
      counterLock.unlock();
    }
  }

  @Override
  public void run() {
    while(counter<1000){
      incrementCounter();
    }
  }

  public static void main(String[] args) {
    Main te = new Main();
    Thread thread1 = new Thread(te);
    Thread thread2 = new Thread(te);

    thread1.start();
    thread2.start();
  }
}
