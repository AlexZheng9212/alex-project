package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Offer50 {
  public char firstUniqChar(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      char ch = s.charAt(i);
      if (position.containsKey(ch)) {
        position.put(ch, -1);
      } else {
        position.put(ch, i);
      }
    }
    int first = n;
    for (Map.Entry<Character, Integer> entry : position.entrySet()) {
      int pos = entry.getValue();
      if (pos != -1 && pos < first) {
        first = pos;
      }
    }
    return first == n ? ' ' : s.charAt(first);
  }
}
