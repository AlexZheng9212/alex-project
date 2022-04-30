package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution146_2 {

}

class LRUCache {

  Node head;
  Node tail;
  int size;
  int maxSize;
  Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.size = 0;
    this.maxSize = capacity;
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  // move to head
  public int get(int key) {
    Node node = map.get(key);
    if (node == null)
      return -1;
    moveToHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      node = new Node(key, value, null, null);
      addToHead(node);
      map.put(key, node);

      size++;
      if (size > maxSize) {
        Node node1 = removeTail();
        map.remove(node1.key);
        size--;
      }

    } else {
      node.val = value;
      moveToHead(node);
    }
  }

  // 先建立node的两条线，再去弄别人的
  private void addToHead(Node node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;

  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }

  private Node removeTail() {
    Node res = tail.prev;
    removeNode(res);
    return res;
  }

  private class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int _key, int _val, Node _next, Node _prev) {
      this.key = _key;
      this.val = _val;
      this.next = _next;
      this.prev = _prev;
    }

    public Node() {
    }
  }
}
