package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>();
    String[] ss = s.split(" ");
    char[] ps = pattern.toCharArray();
    if (ps.length != ss.length) {
      return false;
    }
    for (int i = 0; i < ss.length; i++) {
      if (map.containsKey(ps[i])) {
        if (!map.get(ps[i]).equals(ss[i])) {
          return false;
        }
        continue;
      } else {
        if (map.containsValue(ss[i])) {
          return false;
        }
        map.put(ps[i], ss[i]);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String pattern = "abba";
    String s = "dog cat cat dog t";
    Solution290 solution290 = new Solution290();
    System.out.println(solution290.wordPattern(pattern, s));
  }
}
