package com.interview.leetcode.solution;

public class Solution161 {
  public boolean isOneEditDistance(String s, String t) {
    int lens = s.length();
    int lent = t.length();
    if (Math.abs(lens - lent) > 1) {
      return false;
    }
    if (lens > lent) {
      return isOneEditDistance(t, s);
    }

    for (int i = 0; i < lens; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (lens == lent) {
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else {
          return s.substring(i).equals(t.substring(i + 1));
        }
      }
    }
    return (lens + 1 == lent);
  }
}