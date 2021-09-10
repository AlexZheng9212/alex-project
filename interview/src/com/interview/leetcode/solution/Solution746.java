package com.interview.leetcode.solution;

class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    /**
     * top down
     */
    public int minCostClimbingStairsV2(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        Solution746 solution746 = new Solution746();
        System.out.println(solution746.minCostClimbingStairsV2(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }
}