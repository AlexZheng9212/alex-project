package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

/**
 * 173. Binary Search Tree Iterator list 个人使用 LIST， Deque也可行。。
 */
public class BSTIterator {
  private List<Integer> list = new ArrayList<>();
  private int pointer = 0;

  public BSTIterator(TreeNode root) {
    helper(root);
  }

  public int next() {
    return list.get(pointer++);
  }

  public boolean hasNext() {
    return pointer < list.size();
  }

  public void helper(TreeNode root) {
    if (root == null)
      return;
    helper(root.left);
    list.add(root.val);
    helper(root.right);
  }
}
