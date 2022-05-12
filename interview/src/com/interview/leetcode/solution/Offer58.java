package com.interview.leetcode.solution;

public class Offer58 {
  public static String reverseLeftWords(String s, int n) {
    StringBuilder sb = new StringBuilder();
    sb.append(s.substring(n));
    sb.append(s.substring(0, n));
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverseLeftWords("abcdegf", 2));
  }
}
