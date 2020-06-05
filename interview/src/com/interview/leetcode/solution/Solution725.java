package com.interview.leetcode.solution;

import java.util.ArrayList;

import com.interview.leetcode.datastruct.ListNode;

public class Solution725 {
  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode counter = root;
    ListNode pointer = root;
    int count = 0;
    while (counter != null && counter.next != null) {
      count++;
      counter = counter.next;
    }
    int[] bucket = new int[k];
    int x = k;
    while (count > 0 && x > 0) {
      int b = count / k;
      count -= b;
      bucket[k - x] = b;
      x--;
    }
    for (int i : bucket) {
      System.out.println(i);
    }
    ListNode[] res = new ListNode[k];
    return res;
  }

  public static void main(String[] args) {
    Solution725 s = new Solution725();
    ListNode root = new ListNode(1);
    ListNode root1 = new ListNode(2);
    ListNode root2 = new ListNode(3);
    ListNode root3 = new ListNode(4);
    root.next = root1;
    root1.next = root2;
    root2.next = root3;

    s.splitListToParts(root, 3);
  }
}