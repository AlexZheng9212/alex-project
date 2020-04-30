package com.interview.leetcode;

public class Solution1423 {
  public int maxScore(int[] cardPoints, int k) {
    int s = sum(cardPoints, 0, cardPoints.length);
    if (k >= cardPoints.length)
      return s;
    int end = cardPoints.length;
    int min = s;
    while (k >= 0) {
      int temp = sum(cardPoints, k, end);
      if (temp < min) {
        min = temp;
      }
      k--;
      end--;
    }
    return s - min;
  }

  private int sum(int[] array, int start, int end) {
    int s = 0;
    for (int i = start; i < end; i++) {
      s += array[i];
    }
    return s;
  }

  public static void main(String[] args) {
    Solution1423 s = new Solution1423();
    int[] cardPoints = new int[] { 1, 2, 3, 4, 5, 6, 1 };
    int k = 3;
    int res = s.maxScore(cardPoints, k);
    System.out.println(res);
  }
}