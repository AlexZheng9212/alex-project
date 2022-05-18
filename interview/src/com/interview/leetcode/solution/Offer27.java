package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.TreeNode;

public class Offer27 {
  public TreeNode mirrorTree(TreeNode root) {
    dfs(root);
    return root;
  }

  void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    dfs(root.left);
    dfs(root.right);
  }
}
