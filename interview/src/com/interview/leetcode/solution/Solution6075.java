package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution6075 {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int len = capacity.length;
    for (int i = 0; i < len; i++) {
      capacity[i] = capacity[i] - rocks[i];
    }
    Arrays.sort(capacity);
    int j = 0;
    int max = 0;
    while (j < len && additionalRocks > 0) {
      int tmp = additionalRocks - capacity[j];
      if (tmp >= 0) {
        max++;
      }
      j++;
      additionalRocks = tmp;
    }
    return max;
  }
}
