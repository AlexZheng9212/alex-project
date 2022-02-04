package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
  // O(n^2)
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int res = 0;
    int len = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        int sum = A[i] + B[j];
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        int sum = C[i] + D[j];
        if (map.containsKey(-sum)) {
          res += map.get(-sum);
        }
      }
    }

    return res;
  }
}
