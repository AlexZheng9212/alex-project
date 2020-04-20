package com.interview.coding.binarytree;

import java.util.LinkedList;

import com.interview.leetcode.datastruct.TreeNode;

public interface BalanceBinaryTree<T> {
  TreeNode create(T[] nums);

  TreeNode insert(TreeNode root, T val);

  TreeNode search(TreeNode root, T val);

  LinkedList<T> dfs(TreeNode root);
}