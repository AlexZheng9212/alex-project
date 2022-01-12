package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int l = 0;

    for (int num : nums) {
      if (map.containsKey(num) && isInRange(l, map.get(num), k)) {
        return false;
      }
      map.put(num, l);
      l++;
    }
    return true;

  }

  private boolean isInRange(int curr, int last, int k) {
    int tmp = Math.abs(curr - last);
    return tmp <= k ? true : false;
  }
}
