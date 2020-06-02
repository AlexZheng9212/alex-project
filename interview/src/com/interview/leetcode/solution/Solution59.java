package com.interview.leetcode.solution;

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n < 1)
            return result;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int k = 1;
        while (k < n * n) {
            for (int col = left; col <= right; col++) {
                result[up][col] = k;
                k++;
            }
            up++;
            if (up > down)
                break;

            for (int row = up; row <= down; row++) {
                result[row][right] = k;
                k++;
            }
            right--;
            if (right < left)
                break;

            for (int col = right; col >= left; col--) {
                result[down][col] = k;
                k++;
            }
            down--;
            if (down < up)
                break;

            for (int row = down; row >= up; row--) {
                result[row][left] = k;
                k++;
            }
            left++;
            if (left > right)
                break;
        }
        return result;
    }
}