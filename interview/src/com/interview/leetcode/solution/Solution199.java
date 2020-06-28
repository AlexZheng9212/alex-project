package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution199 {
  private List<Integer> res = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int level = 0;
    helper(root, hmap, level);
    for (int item : hmap.values()) {
      res.add(item);
    }
    return res;
  }

  private void helper(TreeNode node, HashMap<Integer, Integer> hmap, int level) {
    if (node == null)
      return;
    if (!hmap.containsKey(level))
      hmap.put(level, node.val);
    helper(node.right, hmap, level + 1);
    helper(node.left, hmap, level + 1);
  }
}