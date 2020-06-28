package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.TreeNode;

// flatten 
//      1
//     /  \
//    2    3

//       1
//     /   
//    2  -- 3

//        1
//         \
//          2 
//           \
//             3 

public class Solution114 {
  // 右子树
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    flatten(root.left);
    flatten(root.right);
    if (root.left == null)
      return;
    TreeNode node = root.left;
    while (node.right != null) {
      node = node.right;
    }
    node.right = root.right;
    root.right = root.left;
    root.left = null;
  }

  // 左子树
  public void flattenV2(TreeNode root) {
    if (root == null) {
      return;
    }
    flattenV2(root.left);
    flattenV2(root.right);
    if (root.left == null)
      return;
    TreeNode node = root.left;
    while (node.left != null) {
      node = node.left;
    }
    node.left = root.right;
    root.right = null;
  }

  public static void main(String[] args) {
    TreeNode l1l = new TreeNode(4);
    TreeNode l1r = new TreeNode(5);
    TreeNode left = new TreeNode(2, l1l, l1r);
    TreeNode right = new TreeNode(3);
    TreeNode root = new TreeNode(1, left, right);
    Solution114 s = new Solution114();
    s.flattenV2(root);
    System.out.println(root);
    System.out.println(root.left.left);
    System.out.println(root.left.left.left);
    System.out.println(root.left.left.left.left);

    // System.out.println(root.toString());
  }
}