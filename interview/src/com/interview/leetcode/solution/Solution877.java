package com.interview.leetcode.solution;

import java.util.Arrays;

/**
 * Stone Game DP Classic
 * 
 * 【5，3，4，5】
 */
public class Solution877 {
  public boolean stoneGame(int[] piles) {
    int bob = 0;
    int alice = 0;
    Arrays.sort(piles);
    for (int i = piles.length - 1; i >= 0; i--) {
      if (i % 2 == 0) {
        bob += piles[i];
      } else {
        alice += piles[i];
      }
    }

    return alice > bob;
  }

  public static void main(String[] args) {
    int[] piles = { 5, 3, 4, 5 };
    Solution877 solution877 = new Solution877();
    System.out.println(solution877.stoneGame(piles));
  }
}
