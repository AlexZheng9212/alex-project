package com.interview.leetcode.solution;

class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat[0].length;
        int m = mat.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = mat[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + mat[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + mat[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
                }
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sx = Math.max(0, i - K);
                int sy = Math.max(0, j - K);
                int ex = Math.min(m - 1, i + K);
                int ey = Math.min(n - 1, j + K);
                int res = dp[ex][ey];
                if (sx > 0) {
                    res -= dp[sx - 1][ey];
                }
                if (sy > 0) {
                    res -= dp[ex][sy - 1];
                }
                if (sx > 0 && sy > 0) {
                    res += dp[sx - 1][sy - 1];
                }
                ans[i][j] = res;
            }
        }
        return ans;
    }
}