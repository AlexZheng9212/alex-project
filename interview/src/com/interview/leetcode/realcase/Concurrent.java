package com.interview.leetcode.realcase;

public class Concurrent {
  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 20; i++) {
          
        }
      }
    };
    runnable.run();
  }

}
