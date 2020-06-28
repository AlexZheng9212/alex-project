package com.interview.leetcode.solution;

import java.util.ArrayList;

import com.interview.leetcode.datastruct.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * [3,1,4,null,2] 1
 */
public class Solution230 {
  private ArrayList<Integer> result = new ArrayList<>();

  public int kthSmallest(TreeNode root, int k) {
    dfs(root, result);
    return result.get(k - 1);
  }

  private void dfs(TreeNode node, ArrayList<Integer> result) {
    if (node == null)
      return;
    dfs(node.left, result);
    result.add(node.val);
    dfs(node.right, result);
  }
}