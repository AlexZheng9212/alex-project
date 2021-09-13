package com.interview.leetcode.solution;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 */
/**
 * Given an array of integers nums, find the maximum length of a subarray where
 * the product of all its elements is positive.
 * 
 * A subarray of an array is a consecutive sequence of zero or more values taken
 * out of that array.
 * 
 * Return the maximum length of a subarray with positive product.
 */
public class Solution1567 {
  // dp
  public int getMaxLen(int[] nums) {
    int positive = 0;
    int negtive = 0;
    int maxlen = 0;
    for (int i : nums) {
      if (i > 0) {
        positive++;
        if (negtive > 0)
          negtive++;
      } else if (i < 0) {
        int tmp = positive;
        positive = negtive > 0 ? negtive + 1 : 0;
        negtive = tmp + 1;
      } else {
        positive = negtive = 0;
      }
      maxlen = Math.max(positive, maxlen);
    }
    return maxlen;
  }
}
