package com.interview.leetcode;

import java.util.*;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int col = left; col <= right; ++col) {
                result.add(matrix[up][col]);
            }
            up++;
            if (up > down)
                break;

            for (int row = up; row <= down; ++row) {
                result.add(matrix[row][right]);
            }
            right--;
            if (right < left)
                break;

            for (int col = right; col >= left; --col) {
                result.add(matrix[down][col]);
            }
            down--;
            if (down < up)
                break;

            for (int row = down; row >= up; --row) {
                result.add(matrix[row][left]);
            }
            left++;
            if (left > right)
                break;
        }
        return result;
    }
}