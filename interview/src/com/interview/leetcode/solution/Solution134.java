package com.interview.leetcode.solution;

public class Solution134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0, a = 0, b = 0;
    for (int i = 0; i < gas.length; i++) {
      a += gas[i] - cost[i];
      if (a <= 0) {
        b -= a;
        a = 0;
        start = i + 1;
      }
    }
    if (a >= b) {
      return start;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] gas = { 5, 1, 2, 3, 4 };
    int[] cost = { 4, 4, 1, 5, 1 };
    Solution134 solution134 = new Solution134();
    System.out.println(solution134.canCompleteCircuit(gas, cost));
  }
}
