package com.interview.leetcode;

public class ThreadWork extends Thread {
  @Override
  public void run() {
    while (!isInterrupted()) {
      try {
        Thread.sleep(1000);
        System.out.println("thread");
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }

    }
  }

  public static void main(String[] args) {
    ThreadWork work = new ThreadWork();
    work.start();
    long time = System.currentTimeMillis();
    while (time + 3000 != System.currentTimeMillis()) {
      continue;
    }
    work.interrupt();
    System.out.println("exit");
  }

}
