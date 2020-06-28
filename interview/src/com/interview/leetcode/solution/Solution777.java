package com.interview.leetcode.solution;

public class Solution777 {
  boolean ans = false;

  public boolean isPerfectSquare(int num) {
    if (num == 0 || num == 1)
      return true;
    helper(2, num, num);
    return ans;
  }

  private void helper(long low, long high, long num) {
    long mid = (high + low) / 2;
    long val = mid * mid;
    if (val == num) {
      ans = true;
      return;
    }
    if (mid == high || mid == low) {
      return;
    }
    if (val < num) {
      helper(mid + 1, high, num);
    } else {
      helper(low, mid - 1, num);
    }
  }

  public static void main(String[] args) {
    int num = 808201;
    Solution777 s = new Solution777();
    System.out.println(s.isPerfectSquare(num));
  }
}