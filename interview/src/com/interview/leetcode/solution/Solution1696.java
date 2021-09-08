package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Jump Game VI
 */
/**
 * Input: nums = [1,-1,-2,4,-7,3], k = 2 Output: 7 Explanation: You can choose
 * your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is
 * 7.
 */
public class Solution1696 {
  public int maxResult(int[] nums, int k) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    for (int i = 1; i < nums.length; i++) {
      dp[i] = nums[i] + dp[queue.peekFirst()];
      while (!queue.isEmpty() && dp[i] >= dp[queue.peekLast()]) {
        queue.pollLast();
      }
      while (!queue.isEmpty() && i - queue.peekFirst() >= k) {
        queue.pollFirst();
      }
      queue.offer(i);
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Solution1696 solution1696 = new Solution1696();
    int[] nums = { 10, -5, -2, 4, 0, 3 };
    int k = 3;
    System.out.println(solution1696.maxResult(nums, k));
  }
}
