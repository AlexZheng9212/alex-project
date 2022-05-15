package com.interview.leetcode.solution;

import java.util.Arrays;

public class WCompetition293_2 {
  public int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);
    if (special.length == 0) {
      return top - bottom;
    }
    if (special.length == 1) {
      return Math.max(special[0] - bottom, top - special[0]);
    }
    int max = Math.max(special[0] - bottom, top - special[special.length - 1]);
    System.out.println(max);
    for (int i = 1; i < special.length; i++) {
      int tmp = special[i] - special[i - 1] - 1;
      max = Math.max(max, tmp);
    }
    return max;
  }

  public static void main(String[] args) {
    WCompetition293_2 w = new WCompetition293_2();
    int[] special = { 7, 8, 6 };
    System.out.println(w.maxConsecutive(6, 8, special));
  }
}