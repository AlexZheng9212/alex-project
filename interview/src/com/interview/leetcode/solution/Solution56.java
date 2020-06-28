package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间问题
 */
public class Solution56 {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0 || intervals[0].length == 0) {
      int[][] zero = new int[intervals.length][2];
      return zero;
    }
    int m = intervals.length;
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = i + 1; j < m; j++) {
        if (intervals[j][0] < intervals[i][0]) {
          int[] temp = intervals[j];
          intervals[j] = intervals[i];
          intervals[i] = temp;
        }
      }
    }
    res.add(intervals[0]);
    for (int k = 1; k < m; k++) {
      int[] last = res.get(res.size() - 1);
      if (last[0] <= intervals[k][0] && intervals[k][0] <= last[1]) {
        if (last[1] < intervals[k][1]) {
          last[1] = intervals[k][1];
          res.remove(res.size() - 1);
          res.add(last);
        }
      } else {
        res.add(intervals[k]);
      }
    }
    int[][] ans = new int[res.size()][2];
    return res.toArray(ans);
  }

  public static void main(String[] args) {
    Solution56 s = new Solution56();
    int[][] intervals = new int[][] { { 1, 4 }, { 4, 6 } };
    int[][] res = s.merge(intervals);
    for (int[] item : res) {
      System.out.println(item[0] + " " + item[1]);
    }
  }

}