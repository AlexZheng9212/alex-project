package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer09 {
  public static void main(String[] args) {
    String s = "w a u";
    System.out.println(s.replace(" ", "%20"));
  }

}

class CQueue {
  Deque<Integer> head;
  Deque<Integer> tail;

  public CQueue() {
    head = new ArrayDeque<>();
    tail = new ArrayDeque<>();
  }

  public void appendTail(int value) {
    head.offerLast(value);
    tail.offerFirst(value);
  }

  public int deleteHead() {
    if (head.size() > 0 && tail.size() > 0 && head.size() == tail.size()) {
      int ans = head.pollFirst();
      tail.pollLast();
      return ans;
    }
    return -1;
  }
}
