package com.interview.leetcode;

// import java.util.HashMap;
// import java.util.LinkedHashMap;
// import java.util.concurrent.ConcurrentHashMap;

public class MulitThread {
  public static void main(String[] args) {
    // Thread t1 = new MyThread("Thread1");
    // Thread t2 = new MyThread("Thread2");
    // t1.start();
    // t2.start();
    MyRunnable myRunnable1 = new MyRunnable("Runnable1");
    MyRunnable myRunnable2 = new MyRunnable("Runnable2");

    new Thread(myRunnable1).start();
    new Thread(myRunnable2).start();
  }

}

class MyThread extends Thread {
  private String name;
  private static int counter = 10;

  public MyThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      synchronized (this) {
        if (counter > 0) {
          ExternalFunction.testFunction(counter);
          System.out.println(name + "-" + i + "--->" + counter--);
        }
      }
    }
  }
}

class MyRunnable implements Runnable {
  private static int counter = 10;
  private String name;

  public MyRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      if (counter > 0) {
        ExternalFunction.testFunction(counter);
        System.out.println(name + "-" + i + "-" + counter--);
      }
    }
  }
}

class ExternalFunction {
  // static ConcurrentHashMap<Integer, Integer> champ = new ConcurrentHashMap<>();
  // static HashMap<Integer, Integer> hmap = new HashMap<>();
  // static LinkedHashMap<Integer, Integer> lhmap = new LinkedHashMap<>();

  public static synchronized void testFunction(int num) {
    // lhmap.put(null, null);
    // champ.put(null, null);
    // champ.get(null);
    // hmap.put(null, null);
    // hmap.put(null, 12);
    // hmap.put(null, num);

    // System.out.println(hmap.get(null));
    num = num * 2;
    System.out.println(num);
  }

  public static void main(String[] args) {
    ExternalFunction.testFunction(6);
  }
}