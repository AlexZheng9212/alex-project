package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 139. Word Break
 */
/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 */
public class Solution139 {
  Set<String> set = new HashSet<>();
  Map<String, Boolean> map = new HashMap<>();

  public boolean wordBreak(String s, List<String> wordDict) {
    set.addAll(wordDict);
    return wordBreak(s, set);
  }

  private boolean wordBreak(String s, Set<String> set) {
    if (map.containsKey(s))
      return map.get(s);
    if (set.contains(s)) {
      map.put(s, true);
      return map.get(s);
    }
    for (int i = 1; i < s.length(); i++) {
      String left = s.substring(0, i);
      String right = s.substring(i);
      if (set.contains(right) && wordBreak(left, set)) {
        map.put(s, true);
        return map.get(s);
      }
    }
    map.put(s, false);
    return map.get(s);
  }

  public static void main(String[] args) {
    Solution139 solution139 = new Solution139();
    System.out.println(solution139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }
}
