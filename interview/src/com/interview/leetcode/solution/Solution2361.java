package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution2361 {
  public char repeatedCharacter(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] cs = s.toCharArray();
    int idx = 0;
    for (int i = 0; i < cs.length; i++) {
      int tmp = map.getOrDefault(cs[i], 0) + 1;
      if (tmp == 2) {
        idx = i;
        break;
      }
      map.put(cs[i], tmp);
    }
    return cs[idx];
  }
}
