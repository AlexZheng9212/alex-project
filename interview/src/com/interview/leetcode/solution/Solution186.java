package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution186 {
  public void reverseWords(char[] s) {
    String ss = new String(s);
    String[] sl = ss.split(" ");
    Deque<String> deque = new ArrayDeque<>();
    for (String item : sl) {
      deque.offerLast(item);
    }
    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pollLast());
      if (!deque.isEmpty()) {
        sb.append(" ");
      }
    }
    char[] tmp = sb.toString().toCharArray();
    System.arraycopy(tmp, 0, s, 0, s.length);
  }
}
