package com.interview.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

public class Solution383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    Deque<Character> deque = new LinkedList<>();
    for (char r : ransomNote.toCharArray()) {
      deque.push(r);
    }
    for (char m : magazine.toCharArray()) {
      deque.remove(m);
    }
    return deque.isEmpty();
  }
}