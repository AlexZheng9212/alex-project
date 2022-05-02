package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution1497 {
  public boolean canArrange(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int mod = ((arr[i] % k) + k) % k;
      int count = map.getOrDefault(mod, 0);
      map.put(mod, ++count);
    }

    if (map.getOrDefault(0, 0) % 2 == 1) {
      return false;
    }

    for (Integer item : map.keySet()) {
      if (item == 0) {
        continue;
      }
      if (!map.containsKey(k - item) || !map.get(k - item).equals(map.get(item))) {
        return false;
      }
    }
    return true;
  }
}
