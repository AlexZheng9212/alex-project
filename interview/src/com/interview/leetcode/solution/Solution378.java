package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution378 {
  public int kthSmallest(int[][] matrix, int k) {
    List<Integer> res = new ArrayList<>();
    for (int[] items : matrix) {
      for (int item : items) {
        res.add(item);
      }
    }
    Collections.sort(res);
    return res.get(k - 1);
  }
}