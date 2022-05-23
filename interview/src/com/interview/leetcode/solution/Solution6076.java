package com.interview.leetcode.solution;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Solution6076 {
  public int minimumLines(int[][] stockPrices) {
    int len = stockPrices.length;
    if (len < 2) {
      return 0;
    }
    if (len == 2) {
      return 1;
    }
    Arrays.sort(stockPrices, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    double k = (double) (stockPrices[1][1] - stockPrices[0][1]) / (double) (stockPrices[1][0] - stockPrices[0][0]);
    int ans = 1;
    for (int i = 2; i < len; i++) {
      System.out.println(k);
      if (k != (double) ((stockPrices[i][1] - stockPrices[i - 1][1])
          / (double) (stockPrices[i][0] - stockPrices[i - 1][0]))) {
        k = ((double) (stockPrices[i][1] - stockPrices[i - 1][1])
            / (double) (stockPrices[i][0] - stockPrices[i - 1][0]));
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] stockPrices = { { 83, 35 }, { 79, 51 }, { 61, 48 }, { 54, 87 }, { 44, 93 },
        { 22, 5 }, { 87, 28 }, { 64, 8 }, { 89, 78 }, { 62, 83 },
        { 58, 72 }, { 48, 7 }, { 97, 16 }, { 27, 100 }, { 65, 48 }, { 11, 31 }, { 29, 76 }, { 93, 29 }, { 72, 59 },
        { 73, 74 }, { 9, 90 }, { 66, 81 }, { 12, 8 }, { 86, 80 }, { 84, 43 }, { 36, 63 },
        { 80, 45 }, { 81, 88 }, { 95, 5 }, { 40, 59 } };
    Solution6076 s = new Solution6076();
    System.out.println(s.minimumLines(stockPrices));
  }
}
