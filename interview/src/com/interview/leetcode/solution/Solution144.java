package com.interview.leetcode.solution;

import java.util.*;

import com.interview.leetcode.datastruct.TreeNode;

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        res.add(root.val);

        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            dfs(root.right, res);
        }
        if (root.right == null) {
            dfs(root.left, res);
        }
    }

}