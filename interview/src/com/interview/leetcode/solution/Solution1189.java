package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 */
public class Solution1189 {
  public int maxNumberOfBalloons(String text) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      if (map.get(text.charAt(i)) == null) {
        map.put(text.charAt(i), 1);
      } else {
        map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
      }
    }
    int a = Math.min(map.getOrDefault('a', 0), Math.min(map.getOrDefault('b', 0), map.getOrDefault('n', 0)));
    int b = Math.min(map.getOrDefault('l', 0) / 2, map.getOrDefault('o', 0) / 2);
    return Math.min(a, b);
  }

  public static void main(String[] args) {

    Solution1189 solution1189 = new Solution1189();
    System.out.println(solution1189.maxNumberOfBalloons("ballon"));
  }
}
