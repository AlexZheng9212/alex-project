package com.interview.leetcode.solution;

public class Solution2125 {
  public int numberOfBeams(String[] bank) {
    int res = 0;
    int tmpCount = 0;
    for (String item : bank) {
      int tmp = 0;
      for (int i = 0; i < item.length(); i++) {
        if (item.charAt(i) == '1') {
          tmp++;
        }
      }
      if (tmp > 0) {
        res += tmpCount * tmp;
        tmpCount = tmp;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String[] bank = { "011001", "000000", "010100", "001000" };
    Solution2125 solution2125 = new Solution2125();
    int res = solution2125.numberOfBeams(bank);
    System.out.println(res);
  }
}
