package com.interview.leetcode.solution;

public class Solution165 {
  public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int max = v1.length > v2.length ? v1.length : v2.length;
    int[] a1 = new int[max];
    int[] a2 = new int[max];
    for (int i = 0; i < v1.length; i++) {
      a1[i] = Integer.parseInt(v1[i]);
    }
    for (int i = 0; i < v2.length; i++) {
      a2[i] = Integer.parseInt(v2[i]);
    }
    for (int i = 0; i < max; i++) {
      if (a1[i] != a2[i]) {
        return (a1[i] > a2[i] ? 1 : -1);
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    String version1 = "0.1";
    String version2 = "1.1";
    System.out.println(compareVersion(version1, version2));
  }

}
