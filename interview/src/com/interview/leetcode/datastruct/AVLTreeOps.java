package com.interview.leetcode.datastruct;

public interface AVLTreeOps {
  AVLNode put(int key, Object value);

  AVLNode del(int key);

  AVLNode get(int key);

  AVLNode next(AVLNode node);

  AVLNode prev(AVLNode node);

}