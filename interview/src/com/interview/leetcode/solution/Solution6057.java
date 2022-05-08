package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.TreeNode;

public class Solution6057 {
  int ans = 0;

  public int averageOfSubtree(TreeNode root) {
    dfs(root);
    return ans;
  }

  int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int val = root.val;
    int lsum = dfs(root.left);
    int rsum = dfs(root.right);
    int loc = dfs2(root);
    int tmp = (val + lsum + rsum) / loc;
    if (tmp == val) {
      System.out.println("tmp == val " + val);
      ans++;
    }
    return val + lsum + rsum;
  }

  int dfs2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + dfs2(root.left) + dfs2(root.right);
  }

  public static void main(String[] args) {
    // [4,8,5,0,1,null,6]
    TreeNode zero = new TreeNode(0);
    TreeNode one = new TreeNode(1);
    TreeNode six = new TreeNode(6);
    TreeNode five = new TreeNode(5, null, six);
    TreeNode eight = new TreeNode(8, zero, one);
    TreeNode root = new TreeNode(4, eight, five);

    Solution6057 solution6057 = new Solution6057();
    System.out.println(solution6057.averageOfSubtree(root));
  }

}
