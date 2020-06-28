package com.interview.leetcode.solution;

import java.util.*;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution300 s = new Solution300();
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int res = s.lengthOfLIS(nums);
        System.out.println(res);
    }
}