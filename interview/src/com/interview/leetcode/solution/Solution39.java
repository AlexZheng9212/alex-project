package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
  private List<List<Integer>> ans;
  private int[] nums;
  private int target;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.ans = new LinkedList<>();
    this.nums = candidates;
    this.target = target;
    Arrays.sort(nums);
    backtrack(0, 0, new LinkedList<>());
    return ans;
  }

  private void backtrack(int start, int sum, List<Integer> prefix) {
    if (sum == target) {
      ans.add(new LinkedList<>(prefix));
      return;
    }
    for (int j = start; j < nums.length; j++) {
      if (nums[j] + sum <= target) {
        prefix.add(nums[j]);
        backtrack(j, sum + nums[j], prefix);
        prefix.remove(prefix.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] candidates = { 1, 2, 3 };
    int target = 4;
    Solution39 solution39 = new Solution39();
    System.out.println(solution39.combinationSum(candidates, target));
  }
}