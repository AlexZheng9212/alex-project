package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution155 {
  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(-2);
    stack.push(0);
    stack.push(-3);
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.top());
    System.out.println(stack.min());
  }

}

class MinStack {
  Deque<Integer> q;

  public MinStack() {
    q = new ArrayDeque<>();
  }

  public void push(int x) {
    q.offerLast(x);
  }

  public void pop() {
    q.pollLast();
  }

  public int top() {
    return q.getLast();
  }

  public int min() {
    int min = Integer.MAX_VALUE;
    Iterator<Integer> iterator = q.iterator();
    while (iterator.hasNext()) {
      int a = iterator.next();
      if (a < min) {
        min = a;
      }
    }
    return min;
  }
}