package com.interview.algorithms.basicdatastruct;

import com.interview.leetcode.datastruct.ListNode;

/**
 * 10.2-3
 * 
 * 用ListNode实现队列
 */
public class MyLinkedNodeQueue {
  ListNode head;
  ListNode prev = new ListNode(-1);

  public void push(int val) {
    if (head == null) {
      head = new ListNode(val);
      prev.next = head;
    } else {
      ListNode temp = new ListNode(val);
      head.next = temp;
      head = temp;
    }
  }

  public int pop() {
    if (prev.next == null) {
      throw new Error();
    }
    int res = prev.next.val;
    prev.next = prev.next.next;
    return res;
  }

  public static void main(String[] args) {
    MyLinkedNodeQueue mq = new MyLinkedNodeQueue();
    mq.push(1);
    mq.push(2);
    mq.push(3);
    System.out.println(mq.prev.next.toString());
    mq.pop();
    mq.pop();
    mq.push(4);
    System.out.println(mq.prev.next.toString());
  }
}

class CycleQueue {
  ListNode head;
  ListNode prev = new ListNode(-1);

  public void push(int val) {
    if (head == null) {
      head = new ListNode(val);
      prev.next = head;
    } else {
      ListNode temp = new ListNode(val);
      head.next = temp;
      temp.next = prev.next;
      head = temp;
    }
  }

  public int pop(int val) {
    while (head.next.val != val) {
      head = head.next;
    }
    if (prev.next.val == head.next.val) {
      prev.next = prev.next.next;
    }
    int res = head.next.val;
    head.next = head.next.next;
    return res;
  }

  public static void main(String[] args) {
    CycleQueue mq = new CycleQueue();
    mq.push(1);
    mq.push(2);
    mq.push(3);
    int ans = mq.pop(1);
    System.out.println(ans);
    mq.pop(3);
    mq.push(4);
    while (mq.prev.next != null) {
      System.out.println(mq.prev.next.val);
      mq.prev.next = mq.prev.next.next;
    }
  }
}