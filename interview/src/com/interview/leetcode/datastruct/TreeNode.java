package com.interview.leetcode.datastruct;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	};

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		List<Integer> array = new ArrayList<>();
		preOrder(this, array);
		return array.toString();
	}

	public void preOrder(TreeNode root, List<Integer> array) {
		if (root == null)
			return;
		array.add(root.val);
		preOrder(root.left, array);
		preOrder(root.right, array);
	}
}