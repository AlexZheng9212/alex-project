package com.interview.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a
 * list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 */

public class Solution216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new LinkedList<>();
    cal(1, k, n, new LinkedList<>(), res);
    return res;
  }

  private void cal(int start, int k, int n, List<Integer> tmp, List<List<Integer>> res) {
    if (k == 0 || n < 0) {
      if (n == 0) {
        res.add(new LinkedList<>(tmp));
      }
      return;
    }
    for (int i = start; i <= 9; i++) {
      tmp.add(i);
      cal(i + 1, k - 1, n - i, tmp, res);
      tmp.remove(tmp.size() - 1);
    }
  }

  public static void main(String[] args) {
    int k = 3, n = 7;
    Solution216 s = new Solution216();
    System.out.println(s.combinationSum3(k, n));
  }
}
