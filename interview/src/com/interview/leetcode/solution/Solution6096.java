package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution6096 {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int[] res = new int[spells.length];
    for (int i = 0; i < spells.length; i++) {
      int tmp = potions.length;
      for (int j = 0; j < potions.length; j++) {
        long t = spells[i] * potions[j];
        if (t >= success) {
          tmp = j;
          break;
        }
      }
      res[i] = potions.length - tmp;
    }
    return res;
  }
}
