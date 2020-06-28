package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.TreeNode;

class Solution129 {
    public int sumNumbers(TreeNode root) {
        int res = dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int s) {
        if (root == null) {
            return s;
        }
        s = s * 10 + root.val;
        int left = dfs(root.left, s);
        int right = dfs(root.right, s);
        if (root.left == null) {
            return right;
        } else if (root.right == null) {
            return left;
        } else {
            return right + left;
        }

    }
}