package com.interview.leetcode;

public class MulitThread {
  public static void main(String[] args) {
    Thread t1 = new MyThread("Thread1");
    Thread t2 = new MyThread("Thread2");
    t1.start();
    t2.start();
    // MyRunnable myRunnable = new MyRunnable("Runnable");
    // new Thread(myRunnable).start();
    // new Thread(myRunnable).start();
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
      System.out.println(name + "-" + i + "-" + counter);
      counter--;

    }
  }
}

class ExternalFunction {

  public synchronized void testFunction(int num) {
    num = num * 2;
    System.out.println(num);
  }
}