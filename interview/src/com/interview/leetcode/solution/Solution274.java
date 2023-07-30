package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution274 {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = 0;
    int idx = citations.length - 1;
    while (idx >= 0 && citations[idx] > h) {
      h++;
      idx--;
    }
    return h;
  }
}
