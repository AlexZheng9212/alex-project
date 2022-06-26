package com.interview.leetcode.solution;

import java.util.PriorityQueue;

public class Solution2233 {
  int mod = 1000000007;

  public int maximumProduct(int[] nums, int k) {
    if (nums.length == 1) {
      return (nums[0] + k) % mod;
    }
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    for (int e : nums) {
      pQueue.offer(e);
    }
    while (k > 0) {
      int min = pQueue.poll() + 1;
      pQueue.offer(min);
      k--;
    }
    long ans = 1;
    while (pQueue.iterator().hasNext()) {
      ans = ans * ((long) pQueue.poll()) % mod;
    }
    return (int) ans;
  }

  public static void main(String[] args) {

  }
}
