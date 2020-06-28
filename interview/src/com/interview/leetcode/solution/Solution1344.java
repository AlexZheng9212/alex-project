package com.interview.leetcode.solution;

class Solution1344 {
    int len;

    public int maxJumps(int[] arr, int d) {
        len = arr.length;
        int[] res = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, dp(arr, res, i, d));
        }
        for (int item : res) {
            System.out.println(item);
        }

        return 0;
    }

    private int dp(int[] arr, int[] res, int i, int d) {
        if (res[i] != 0)
            return res[i];
        int ans = 1;
        for (int j = i + 1; j < Math.min(i + d + 1, len) && arr[i] > arr[j]; j++) {
            ans = Math.max(ans, dp(arr, res, j, d) + 1);
        }
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[i] > arr[j]; j--) {
            ans = Math.max(ans, dp(arr, res, j, d) + 1);
        }

        return res[i] = ans;
    }

    public static void main(String[] args) {
        Solution1344 s = new Solution1344();
        int d = 1;
        int[] arr = new int[] { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 };

        s.maxJumps(arr, d);
    }
}