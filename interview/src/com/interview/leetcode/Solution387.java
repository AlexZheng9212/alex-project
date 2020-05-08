package com.interview.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution387 {
  public int firstUniqChar(String s) {
    char[] c = s.toCharArray();
    Deque<Character> deque = new LinkedList<>();
    HashSet<Character> set = new HashSet<>();
    for (char item : c) {
      if (set.contains(item))
        continue;
      if (deque.contains(item)) {
        deque.remove(item);
        set.add(item);
      } else {
        deque.add(item);
      }
    }
    if (deque.size() < 1) {
      return -1;
    }
    char first = deque.peekFirst();
    for (int i = 0; i < c.length; i++) {
      if (c[i] == first) {
        return i;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    String test = "aadadaad";
    Solution387 s = new Solution387();
    System.out.println(s.firstUniqChar(test));
  }
}