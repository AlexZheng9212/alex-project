package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution151 {
  public String reverseWords(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    Deque<Character> qDeque = new ArrayDeque<>();
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (c[i] == ' ' && qDeque.size() > 0 && c[i] == qDeque.getLast()) {
        continue;
      }
      qDeque.offerLast(c[i]);
    }
    StringBuilder sb = new StringBuilder();
    StringBuilder tmp = new StringBuilder();
    while (qDeque.iterator().hasNext()) {
      char item = qDeque.pollLast();
      if (item == ' ') {
        tmp.reverse();
        sb.append(tmp);
        sb.append(item);
        tmp.delete(0, tmp.capacity());
      } else {
        tmp.append(item);
      }
      if (!qDeque.iterator().hasNext()) {
        tmp.reverse();
        sb.append(tmp);
      }
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    String s = "the sky is blue";
    System.out.println(s.trim());
    Solution151 solution151 = new Solution151();
    System.out.println(solution151.reverseWords(s));
  }
}
