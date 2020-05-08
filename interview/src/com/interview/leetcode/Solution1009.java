package com.interview.leetcode;

/**
 * same as 476
 */
public class Solution1009 {
  public int bitwiseComplement(int N) {
    String s = Integer.toBinaryString(N);

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        res.append("0");
      } else {
        res.append("1");
      }
    }
    return Integer.parseInt(res.toString(), 2);

  }

  public static void main(String[] args) {
    Solution1009 s = new Solution1009();
    System.out.println(s.bitwiseComplement(664526));
  }
}