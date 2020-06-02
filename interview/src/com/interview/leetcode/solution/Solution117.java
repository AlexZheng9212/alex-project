package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.Node;

public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.next = root.right;
        }
        if (root.next != null) {
            root.right = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {

    }
}
