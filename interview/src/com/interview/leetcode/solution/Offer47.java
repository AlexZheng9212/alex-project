package com.interview.leetcode.solution;

public class Offer47 {
  public int maxValue(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (i == 0) {
          grid[i][j] += grid[i][j - 1];
          continue;
        }
        if (j == 0) {
          grid[i][j] += grid[i - 1][j];
          continue;
        }
        grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
      }
    }
    return grid[m - 1][n - 1];
  }
}
