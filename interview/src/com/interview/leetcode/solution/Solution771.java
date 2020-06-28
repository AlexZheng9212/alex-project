package com.interview.leetcode.solution;

import java.util.HashSet;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 */
public class Solution771 {
  public int numJewelsInStones(String J, String S) {
    int res = 0;
    HashSet<Character> hset = new HashSet<>();
    char[] jChar = J.toCharArray();
    char[] sChar = S.toCharArray();
    for (char j : jChar) {
      hset.add(j);
    }
    for (char s : sChar) {
      if (hset.contains(s)) {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution771 s = new Solution771();
    String J = "z";
    String S = "ZZ";
    int res = s.numJewelsInStones(J, S);
    System.out.println(res);
  }
}