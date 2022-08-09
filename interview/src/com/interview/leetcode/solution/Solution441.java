package com.interview.leetcode.solution;

public class Solution441 {
  public static int arrangeCoins(int n) {
    return ((int) Math.sqrt(8 * n + 1) - 1) / 2;
  }

  public static void main(String[] args) {
    System.out.println(arrangeCoins(8));
  }
}

// dp
// public int arrangeCoins(int n) {
// int ans = 1;
// if (n <= 1) {
// return ans;
// }

// int[] dp = new int[n];
// for (int i = 1; i < n; i++) {
// int tmp = dp[i - 1] + i + 1;
// if (n == tmp) {
// ans = i + 1;
// break;
// } else if (n < tmp) {
// ans = i;
// break;
// }
// }

// return ans;
// }