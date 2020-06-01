package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    if (intervals.length == 0 || intervals[0].length == 0) {
      res.add(newInterval);
      return res.toArray(new int[res.size()][2]);
    }

    boolean over = false;
    boolean isMerge = false;
    for (int i = 0; i < intervals.length; i++) {
      if (isMerge) {
        res.add(intervals[i]);
        continue;
      }
      int[] temp = new int[2];

      if (newInterval[0] < intervals[i][0]) {
        temp[0] = newInterval[0];
        int j = i;
        while (j < intervals.length) {
          if (intervals[j][0] <= newInterval[1] && newInterval[1] <= intervals[j][1]) {
            temp[1] = intervals[j][1];
            break;
          }
          if (newInterval[1] < intervals[j][0]) {
            temp[1] = newInterval[1];
            over = true;
            break;
          }
          if (intervals[j][1] < newInterval[1]) {
            temp[1] = newInterval[1];
            i++;
          }
          j++;
        }
        res.add(temp);
        if (over) {
          res.add(intervals[i]);
        }
        isMerge = true;
      } else if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]) {
        temp[0] = intervals[i][0];
        int j = i;
        while (j < intervals.length) {
          if (intervals[j][0] <= newInterval[1] && newInterval[1] <= intervals[j][1]) {
            temp[1] = intervals[j][1];
            break;
          }
          if (newInterval[1] < intervals[j][0]) {
            temp[1] = newInterval[1];
            over = true;
            break;
          }
          if (intervals[j][1] < newInterval[1]) {
            temp[1] = newInterval[1];
            i++;
          }
          j++;
        }
        res.add(temp);
        if (over) {
          res.add(intervals[i]);
        }
        isMerge = true;
      } else {
        res.add(intervals[i]);
      }
    }
    if (!isMerge) {
      res.add(newInterval);
    }
    return res.toArray(new int[res.size()][2]);
  }

  public static void main(String[] args) {
    int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
    int[] newInterval = { 4, 8 };
    // int[][] intervals = { { 1, 3 }, { 6, 9 } };
    // int[] newInterval = { 2, 5 };
    // int[][] intervals = { { 1, 3 } };
    // int[] newInterval = { 0, 5 };
    Solution57 s = new Solution57();
    System.out.println(Integer.MAX_VALUE + 1);
    int[][] ans = s.insert(intervals, newInterval);
    for (int[] item : ans) {
      System.out.println(item[0] + " " + item[1]);
    }
  }
}