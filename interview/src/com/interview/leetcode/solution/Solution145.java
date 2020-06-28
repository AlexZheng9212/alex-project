package com.interview.leetcode.solution;

import java.util.List;

import com.interview.leetcode.datastruct.TreeNode;

import java.util.ArrayList;;

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;

    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        dfs(res, root.right);
        res.add(root.val);

    }
}