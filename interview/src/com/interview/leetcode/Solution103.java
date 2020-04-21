package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(root, 0, ans);
    for (int i = 1; i < ans.size(); i += 2) {
      Collections.reverse(ans.get(i));
    }
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