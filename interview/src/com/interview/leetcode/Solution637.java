package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution637 {
  public List<Double> averageOfLevels(TreeNode root) {
    List<List<Long>> levels = new ArrayList<>();
    dfs(root, 0, levels);
    List<Double> ans = new ArrayList<>();
    for (List<Long> item : levels) {
      long sum = 0;
      for (long i : item) {
        sum += i;
      }
      ans.add((double) sum / item.size());
    }
    return ans;
  }

  public List<Double> averageOfLevelsBfs(TreeNode root) {
    List<Double> ans = new ArrayList<>();
    if (root == null)
      return ans;
    List<TreeNode> cur = new ArrayList<>(), next = new ArrayList<>();
    cur.add(root);
    while (!cur.isEmpty()) {
      long sum = 0;
      for (TreeNode it : cur) {
        sum += it.val;
        if (it.left != null)
          next.add(it.left);
        if (it.right != null)
          next.add(it.right);
      }
      ans.add((double) sum / cur.size());
      cur.clear();
      cur.addAll(next);
      next.clear();
    }
    return ans;
  }

  private void dfs(TreeNode root, int depth, List<List<Long>> levels) {
    if (root == null)
      return;
    List<Long> temp = new ArrayList<>();
    while (levels.size() <= depth)
      levels.add(temp);
    levels.get(depth).add((long) root.val);
    dfs(root.left, depth + 1, levels);
    dfs(root.right, depth + 1, levels);
  }
}