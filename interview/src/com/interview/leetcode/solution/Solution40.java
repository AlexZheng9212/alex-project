package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 */

// result=[]
// def backtrack(路径,选择列表):
// if 满足结束条件:
// result.add(路径)
// return
// for 选择 in 选择列表:
// 做选择
// backtrack(路径,选择列表)
// 撤销选择

public class Solution40 {
  private List<List<Integer>> ans; // result = []
  private int[] nums;
  private int target;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    this.ans = new LinkedList<>();
    this.nums = candidates;
    this.target = target;
    Arrays.sort(this.nums);
    backtrack(0, 0, new LinkedList<>());
    return ans;
  }

  private void backtrack(int start, int sum, List<Integer> prefix) {
    if (sum == target) { // 是否满足条件
      ans.add(new LinkedList<>(prefix));
      return;
    }
    for (int j = start; j < nums.length; j++) {
      if (j > start && nums[j] == nums[j - 1]) {
        continue;
      }
      if (sum + nums[j] <= target) {
        prefix.add(nums[j]); // 做选择
        backtrack(j + 1, sum + nums[j], prefix); // 递归
        prefix.remove(prefix.size() - 1); // 撤销选择
      }
    }
  }
}
