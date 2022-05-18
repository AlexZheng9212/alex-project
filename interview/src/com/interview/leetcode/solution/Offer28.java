package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.TreeNode;

public class Offer28 {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return dfs(root.left, root.right);
  }

  boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null) {
      return false;
    }
    if (right == null) {
      return false;
    }
    if (left.val == right.val) {
      return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    return false;
  }

}
