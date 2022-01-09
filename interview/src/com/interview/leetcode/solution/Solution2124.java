package com.interview.leetcode.solution;

public class Solution2124 {
  public boolean checkString(String s) {
    for (int i = 1; i < s.length(); i++) {
      if ('a' == s.charAt(i) && 'b' == s.charAt(i - 1)) {
        return false;
      }
    }
    return true;
  }
}
