package com.interview.algorithms.basicdatastruct;

import com.interview.leetcode.datastruct.ListNode;

/**
 * 10.2-2 用listnode实现栈
 * 
 * 数据结构沿用ListNode
 */
public class MyLinkedNodeStack {
  ListNode head;

  public void push(int val) {
    if (head == null) {
      head = new ListNode(val);
    } else {
      ListNode temp = new ListNode(val);
      temp.next = head;
      head = temp;
    }
  }

  public int pop() {
    if (head == null) {
      throw new Error();
    }
    int res = head.val;
    ListNode temp = head.next;
    head.next = null;
    head = temp;
    return res;
  }

  public static void main(String[] args) {
    MyLinkedNodeStack ms = new MyLinkedNodeStack();
    ms.push(1);
    ms.push(2);
    ms.push(3);
    System.out.println(ms.head.toString());
    ms.pop();
    ms.pop();
    ms.push(4);
    System.out.println(ms.head.toString());

  }
}