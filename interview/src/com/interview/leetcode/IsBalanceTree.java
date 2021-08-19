package com.interview.leetcode;

import com.interview.leetcode.datastruct.TreeNode;

public class IsBalanceTree {
  public boolean solution(TreeNode node) {
    if (node == null) {
      return true;
    }
    int left = depth(node.left);
    int right = depth(node.right);
    if (Math.abs(right - left) > 1) {
      return false;
    }
    boolean bleft = solution(node.left);
    boolean bright = solution(node.right);
    return bleft && bright;
  }

  public int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int right = depth(node.right);
    int left = depth(node.left);
    return (left > right) ? left + 1 : right + 1;
  }
}