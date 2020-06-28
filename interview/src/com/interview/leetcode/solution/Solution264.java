/**
 * Ugly Number II
 * 
 * hint 1: The naive approach is to call isUgly for every number until you reach
 * the nth one. Most numbers are not ugly. Try to focus your effort on
 * generating only the ugly ones.
 * 
 * hint 2: An ugly number must be multiplied by either 2, 3, or 5 from a smaller
 * ugly number.
 * 
 * hint 3: The key is how to maintain the order of the ugly numbers. Try a
 * similar approach of merging from three sorted lists: L1, L2, and L3.
 * 
 * hint 4: Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 *
 * 2, L2 * 3, L3 * 5).
 */
package com.interview.leetcode.solution;

class Solution264 {
    public int nthUglyNumber(int n) {
        int i2 = 0, i7 = 0, i13 = 0, i19 = 0;
        int n2 = 2, n7 = 7, n13 = 13, n19 = 19;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(n2, n7), Math.min(n13, n19));
            if (dp[i] == n2)
                n2 = 2 * dp[++i2];
            if (dp[i] == n7)
                n7 = 7 * dp[++i7];
            if (dp[i] == n13)
                n13 = 13 * dp[++i13];
            if (dp[i] == n19)
                n19 = 19 * dp[++i19];

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution264 s = new Solution264();
        int n = 12;
        System.out.println(s.nthUglyNumber(n));
    }
}