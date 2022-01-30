package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2150 {
  public List<Integer> findLonely(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    for (int i : nums) {
      int count = map.getOrDefault(i, 0);
      count++;
      map.put(i, count);
    }
    for (int j : nums) {
      int l = j - 1;
      int r = j + 1;
      int jt = map.getOrDefault(j, 0);
      int lt = map.getOrDefault(l, 0);
      int rt = map.getOrDefault(r, 0);
      if (jt > 1 || lt > 0 || rt > 0) {
        continue;
      } else {
        ans.add(j);
      }
    }
    return ans;
  }
}
