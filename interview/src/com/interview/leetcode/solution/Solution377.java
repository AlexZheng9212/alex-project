package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution377 {
  private List<List<Integer>> ans;
  private int[] nums;
  private int target;

  public int combinationSum4(int[] candidates, int target) {
    return dp(candidates, target);
  }

  private int dp(int[] candidates, int target) {
    int[] d = new int[target + 1];
    d[0] = 1;
    int tmp = 0;
    while (++tmp <= target) {
      for (int num : candidates) {
        if (tmp - num >= 0) {
          d[tmp] += d[tmp - num];
        }
      }
    }
    return d[target];
  }

  public int combinationSum4OT(int[] candidates, int target) {
    this.ans = new LinkedList<>();
    this.nums = candidates;
    this.target = target;
    Arrays.sort(nums);
    backtrack(0, 0, new LinkedList<>());
    return ans.size();
  }

  // overtime
  private void backtrack(int start, int sum, List<Integer> prefix) {
    if (sum == target) {
      ans.add(new LinkedList<>(prefix));
      return;
    }
    for (int j = start; j < nums.length; j++) {
      if (nums[j] + sum <= target) {
        prefix.add(nums[j]);
        backtrack(start, sum + nums[j], prefix);
        prefix.remove(prefix.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] candidates = { 4, 2, 1 };
    int target = 32;
    Solution377 solution377 = new Solution377();
    System.out.println(solution377.combinationSum4(candidates, target));
  }

}