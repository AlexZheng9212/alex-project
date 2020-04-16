package com.interview.leetcode;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution701 {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode res = root;
    if (root.val < val) {
      if (root.right == null) {
        root.right = new TreeNode(val);
      } else {
        insertIntoBST(root.right, val);
      }
    }
    if (root.val > val) {
      if (root.left == null) {
        root.left = new TreeNode(val);
      } else {
        insertIntoBST(root.left, val);
      }
    }
    return res;
  }
}