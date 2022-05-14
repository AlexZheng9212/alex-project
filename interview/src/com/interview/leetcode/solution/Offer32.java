package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

public class Offer32 {
  public int[] levelOrder(TreeNode root) {
    List<List<Integer>> ll = new ArrayList<>();
    dfs(root, ll, 0);
    List<Integer> tmp = new ArrayList<>();
    for (int i = 0; i < ll.size(); i++) {
      tmp.addAll(ll.get(i));
    }
    int[] ans = new int[tmp.size()];
    for (int i = 0; i < tmp.size(); i++) {
      ans[i] = tmp.get(i);
    }
    return ans;

  }

  void dfs(TreeNode node, List<List<Integer>> ll, int height) {
    if (node == null) {
      return;
    }
    if (height >= ll.size()) {
      ll.add(new ArrayList<>());
    }
    ll.get(height).add(node.val);
    dfs(node.left, ll, height + 1);
    dfs(node.right, ll, height + 1);
  }

  public static void main(String[] args) {
    int ans = 1 % 2;
    System.out.println(ans);
  }
}
