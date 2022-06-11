package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution253 {
  public int minMeetingRooms(int[][] intervals) {
    int len = intervals.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return 1;
    }
    int[] start = new int[len];
    int[] end = new int[len];
    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);

    int s = 0;
    int e = 0;
    int tmp = 0;
    int max = 0;
    while (s < len && e < len) {
      if (start[s] < end[e]) {
        tmp = max + 1;
        max = Math.max(max, tmp);
        s++;
        continue;
      } else {
        tmp = max - 1;
        max = Math.max(max, tmp);
        e++;
        continue;
      }
    }
    return max;
  }
}
