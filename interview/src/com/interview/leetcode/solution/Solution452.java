package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution452 {
  public int findMinArrowShots(int[][] points) {
    int arrow = 1;
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int tail = points[0][1];
    for (int i = 0; i < points.length; i++) {
      if (points[i][0] > tail) {
        arrow++;
        tail = points[i][1];
      }
    }
    return arrow;
  }
}
