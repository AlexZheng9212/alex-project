package com.interview.leetcode;

class Solution152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        int res = nums[0];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i][1] = nums[i];
            dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] * nums[i]);
            dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] * nums[i]);

            dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] * nums[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] * nums[i]);
            System.out.println(dp[i][1]);

            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 2 };
        Solution152 s = new Solution152();
        int res = s.maxProduct(nums);
        System.out.println(res);
    }
}