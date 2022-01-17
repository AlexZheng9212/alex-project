package com.interview.leetcode.solution;
// package com.interview.leetcode;

import java.util.Arrays;

// class Solution313 {
// public int nthSuperUglyNumber(int n, int[] primes) {
// int item = 0;
// while(item < primes.length ){
// }

// }

// public static void main(String[] args) {
// int n = 10;
// int[] primes = new int[] { 2, 7, 13, 19 };
// Solution313 s = new Solution313();
// System.out.println(s.nthSuperUglyNumber(n, primes));
// }
// }

public class Solution313 {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] uglyNum = new int[n];
    Arrays.fill(uglyNum, 0);
    uglyNum[0] = 1;
    int[] pointer = new int[primes.length];
    Arrays.fill(pointer, 0);
    for (int i = 1; i < n; i++) {
      int tmp = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        tmp = Math.min(tmp, uglyNum[pointer[j]] * primes[j]);
      }
      uglyNum[i] = tmp;
      for (int j = 0; j < primes.length; j++) {
        if (uglyNum[pointer[j]] * primes[j] == tmp) {
          pointer[j]++;
        }
      }
    }
    return uglyNum[n - 1];
  }
}