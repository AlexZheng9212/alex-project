package com.interview.leetcode;

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tchar[i] == schar[j]) {
                if (j == s.length() - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;

    }
}