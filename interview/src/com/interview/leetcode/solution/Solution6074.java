package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution6074 {
  public int percentageLetter(String s, char letter) {
    if (s.length() < 1) {
      return 0;
    }
    double t = 0;
    char[] c = s.toCharArray();
    double len = c.length;
    for (int i = 0; i < len; i++) {
      if (c[i] == letter) {
        t++;
      }
    }
    int ans = (int) Math.floor(t * 100 / len);
    return ans;
  }

  public static void main(String[] args) {
    Solution6074 s = new Solution6074();
    System.out.println(s.percentageLetter("foobar", 'o'));
  }
}
