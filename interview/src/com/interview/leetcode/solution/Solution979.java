package com.interview.leetcode.solution;

import java.util.HashMap;

import com.interview.leetcode.datastruct.TreeNode;

/**
 * 
 * Given the root of a binary tree with N nodes, each node in the tree has
 * node.val coins, and there are N coins total.
 * 
 * In one move, we may choose two adjacent nodes and move one coin from one node
 * to another. (The move may be from parent to child, or from child to parent.)
 * 
 * Return the number of moves required to make every node have exactly one coin.
 */
public class Solution979 {
  private HashMap<TreeNode, Integer> hmap = new HashMap<>();

  public int distributeCoins(TreeNode root) {
    int result = 0;
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, int result) {
    if (root == null)
      return;
    int left = need(root.left);
    int right = need(root.right);
    result += Math.abs(left) + Math.abs(right);
    helper(root.left, result);
    helper(root.right, result);
  }

  private int need(TreeNode root) {
    if (root == null)
      return 0;
    if (hmap.containsKey(root)) {
      return hmap.get(root);
    }
    int res = need(root.left) + 1 - root.val + need(root.right);
    hmap.put(root, res);
    return res;
  }

}