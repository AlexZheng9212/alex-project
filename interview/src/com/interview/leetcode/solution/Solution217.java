package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution217 {
  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      int tmp = map.getOrDefault(n, 0);
      tmp++;
      if (tmp > 1) {
        return true;
      } else {
        map.put(n, tmp);
      }
    }
    return false;
  }
}
