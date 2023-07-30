package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution299 {
  public String getHint(String secret, String guess) {
    Map<Character, Integer> map = new HashMap<>();
    char[] sc = secret.toCharArray();
    char[] gc = guess.toCharArray();
    int len = sc.length;
    for (char c : sc) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int bulls = 0;
    int cows = 0;
    for (int i = 0; i < len; i++) {
      if (sc[i] == gc[i]) {
        bulls++;
        map.put(gc[i], map.get(gc[i]) - 1);
      }
    }
    for (int j = 0; j < len; j++) {
      if (sc[j] != gc[j]) {
        int tmp = map.getOrDefault(gc[j], 0);
        if (tmp > 0) {
          cows++;
          map.put(gc[j], tmp - 1);
        }
      }
    }
    return bulls + "A" + cows + "B";

  }
}
