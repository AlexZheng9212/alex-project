package com.interview.leetcode.solution;

public class Solution6077 {
  public int totalStrength(int[] strength) {
    int mod = 1000000007;
    for (int i = 0; i < strength.length; i++) {
      int tmp = strength[i];
      int sum = strength[i];
      for (int j = i; j < strength.length; j++) {
        int min = Math.min(strength[i], tmp);
        tmp = min;
      }
    }
    return 0;
  }
}
