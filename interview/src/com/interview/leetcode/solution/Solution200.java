package com.interview.leetcode.solution;

public class Solution200 {
  public int numIslands(char[][] grid) {
    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    int ans = 0;
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (grid[x][y] == '1') {
          ans++;
          dfs(grid, x, y, m, n);
        }
      }
    }
    return ans;
  }

  private void dfs(char[][] grid, int x, int y, int m, int n) {
    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x + 1, y, m, n);
    dfs(grid, x - 1, y, m, n);
    dfs(grid, x, y + 1, m, n);
    dfs(grid, x, y - 1, m, n);
  }

}
