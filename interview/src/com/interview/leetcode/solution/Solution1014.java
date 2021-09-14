package com.interview.leetcode.solution;

public class Solution1014 {
  public int maxScoreSightseeingPair(int[] values) {
    int max = Integer.MIN_VALUE;
    int tmp = values[0] + 0;
    for (int i = 1; i < values.length; i++) {
      max = Math.max(tmp + values[i] - i, max);
      tmp = Math.max(tmp, values[i] + i);
    }
    return max;
  }

  public static void main(String[] args) {
    Solution1014 solution1014 = new Solution1014();
    System.out.println(solution1014.maxScoreSightseeingPair(new int[] { 8, 1, 5, 2, 6 }));
  }
}
