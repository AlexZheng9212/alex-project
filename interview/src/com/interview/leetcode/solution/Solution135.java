package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution135 {
  public int candy(int[] ratings) {
    int len = ratings.length;
    int ans = 0;
    if (len < 2) {
      return len;
    }

    int[] dp = new int[len];
    Arrays.fill(dp, 1);
    int l = len - 2;
    int r = 1;
    while (r < len) {
      if (ratings[r - 1] < ratings[r]) {
        dp[r] = dp[r - 1] + 1;
      }
      r++;
    }
    while (l > -1) {
      if (ratings[l] > ratings[l + 1] && dp[l] <= dp[l + 1]) {
        dp[l] = dp[l + 1] + 1;
      }
      l--;
    }
    for (int i : dp) {
      ans += i;
    }
    return ans;
  }
}
