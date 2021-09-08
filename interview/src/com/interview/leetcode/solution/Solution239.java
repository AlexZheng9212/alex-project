package com.interview.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] dp = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.addLast(i);
      if (i - k + 1 >= 0)
        dp[i - k + 1] = nums[deque.getFirst()];
      if (i - k + 1 >= deque.getFirst())
        deque.removeFirst();
    }
    return dp;
  }
}
