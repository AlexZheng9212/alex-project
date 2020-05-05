package com.interview.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers nums and an integer limit, return the size of the
 * longest continuous subarray such that the absolute difference between any two
 * elements is less than or equal to limit.
 * 
 * In case there is no subarray satisfying the given condition return 0.
 * 
 * sliding window
 */
public class Solution1438 {
  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> maxQueue = new LinkedList<>();
    Deque<Integer> minQueue = new LinkedList<>();
    int ans = 0;
    int l = 0;
    for (int r = 0; r < nums.length; ++r) {
      while (!maxQueue.isEmpty() && nums[r] > maxQueue.peekFirst()) {
        maxQueue.pollFirst();
      }
      while (!minQueue.isEmpty() && nums[r] < minQueue.peekFirst()) {
        minQueue.pollFirst();
      }
      maxQueue.push(nums[r]);
      minQueue.push(nums[r]);
      while (maxQueue.peekLast() - minQueue.peekLast() > limit) {

        if (maxQueue.peekLast() == nums[l])
          maxQueue.remove(nums[l]);
        if (minQueue.peekLast() == nums[l])
          minQueue.remove(nums[l]);
        ++l;
      }
      ans = Math.max(ans, r - l + 1);

    }
    return ans;
  }

  public static void main(String[] args) {
    Solution1438 s = new Solution1438();
    int[] nums = new int[] { 8, 2, 4, 7 };
    int limit = 4;
    System.out.println(s.longestSubarray(nums, limit));
  }
}