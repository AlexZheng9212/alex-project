package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(root, 0, ans);
    return ans;

  }

  private void dfs(TreeNode root, int depth, List<List<Integer>> ans) {
    if (root == null)
      return;
    List<Integer> temp = new ArrayList<>();
    while (ans.size() <= depth)
      ans.add(temp);
    ans.get(depth).add(root.val);
    dfs(root.left, depth + 1, ans);
    dfs(root.right, depth + 1, ans);
  }
}