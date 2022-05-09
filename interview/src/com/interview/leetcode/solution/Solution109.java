package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;
import com.interview.leetcode.datastruct.TreeNode;

public class Solution109 {
  public TreeNode sortedListToBST(ListNode head) {
    return build(head, null);
  }

  TreeNode build(ListNode left, ListNode right) {
    if (left == right) {
      return null;
    }
    ListNode mid = findMid(left, right);
    TreeNode root = new TreeNode(mid.val);
    root.left = build(left, mid);
    root.right = build(mid.next, right);
    return root;
  }

  ListNode findMid(ListNode left, ListNode right) {
    ListNode fast = left;
    ListNode slow = left;
    while (fast != right && fast.next != right) {
      fast = fast.next;
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
