package com.interview.leetcode.solution;

public class Solution316 {
  public String removeDuplicateLetters(String s) {
    int freq[] = new int[26];
    int vis[] = new int[26];

    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }

    StringBuilder sBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']--;
      if (vis[s.charAt(i) - 'a'] == 0) {
        while (sBuilder.length() > 0 && (sBuilder.charAt(sBuilder.length() - 1) > s.charAt(i))
            && freq[sBuilder.charAt(sBuilder.length() - 1) - 'a'] > 0) {
          vis[sBuilder.charAt(sBuilder.length() - 1) - 'a'] = 0;
          sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
        sBuilder.append(s.charAt(i));
        vis[s.charAt(i) - 'a'] = 1;
      }
    }
    return sBuilder.toString();

  }

  public static void main(String[] args) {
    Solution316 solution316 = new Solution316();
    String s = "cbacdcbc";
    System.out.println(solution316.removeDuplicateLetters(s));
  }
}
