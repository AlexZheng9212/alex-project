package com.interview.leetcode.solution;

/**
 * Rob House II : 两次dp 【0 ~ i-1] [1 ~ i]
 */
public class Solution213 {
  public int robbak(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);
    // 0 ~ i-1
    int[][] dp1 = new int[nums.length][2];
    dp1[0][1] = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
      dp1[i][1] = dp1[i - 1][0] + nums[i];
    }
    int max1 = Math.max(dp1[nums.length - 2][0], dp1[nums.length - 2][1]);
    // 1 ~ i
    int[][] dp2 = new int[nums.length][2];
    dp2[1][1] = nums[1];
    for (int i = 2; i < nums.length; i++) {
      dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
      dp2[i][1] = dp2[i - 1][0] + nums[i];
    }
    int max2 = Math.max(dp2[nums.length - 1][0], dp2[nums.length - 1][1]);
    return Math.max(max1, max2);
  }

  // my solution
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);
    int max1 = helper(nums, 0, nums.length - 2);
    int max2 = helper(nums, 1, nums.length - 1);
    return Math.max(max1, max2);
  }

  public int helper(int[] nums, int start, int end) {
    if (start == end)
      return nums[start];

    int[] dp = new int[end - start + 1];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Solution213 solution213 = new Solution213();
    System.out.println(solution213.rob(new int[] { 1, 3, 1, 3, 100 }));
  }
}
