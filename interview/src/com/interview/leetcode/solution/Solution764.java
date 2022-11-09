package com.interview.leetcode.solution;

import java.util.Arrays;

/**
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示
 * grid[xi][yi] == 0
 * 
 * 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * 
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为
 * k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * 
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 【1】 = 1阶
 * 【0 1 0】
 * 【1 1 1】
 * 【0 1 0】 = 2阶
 */
public class Solution764 {
  public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] m = new int[n][n];
    int[][] dp = new int[n][n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      Arrays.fill(m[i], 1);
    }
    int mlen = mines.length;
    for (int i = 0; i < mlen; i++) {
      m[mines[i][0]][mines[i][1]] = 0;
    }
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      // 左边
      for (int j = 0; j < n; j++) {
        cnt = m[i][j] == 1 ? cnt + 1 : 0;
        dp[i][j] = cnt;
      }

      cnt = 0;
      // 右边
      for (int j = n - 1; j > -1; j--) {
        cnt = m[i][j] == 1 ? cnt + 1 : 0;
        dp[i][j] = Math.min(dp[i][j], cnt);
      }
    }
    for (int j = 0; j < n; j++) {

      int cnt = 0;
      // 上边
      for (int i = 0; i < n; i++) {
        cnt = m[i][j] == 1 ? cnt + 1 : 0;
        dp[i][j] = Math.min(dp[i][j], cnt);
      }

      cnt = 0;
      // 下边
      for (int i = n - 1; i > -1; i--) {
        cnt = m[i][j] == 1 ? cnt + 1 : 0;
        dp[i][j] = Math.min(dp[i][j], cnt);
        max = Math.max(max, dp[i][j]);

      }

    }
    return max;

  }
}
