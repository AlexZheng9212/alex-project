package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WCompetition293_1 {
  public List<String> removeAnagrams(String[] words) {
    List<String> ans = new ArrayList<>();
    for (String item : words) {
      ans.add(item);
    }
    if (ans.size() < 2) {
      return ans;
    }
    String tmp = "";
    for (int i = 1; i < ans.size(); i++) {
      char[] s1 = ans.get(i - 1).toCharArray();
      char[] s2 = ans.get(i).toCharArray();
      Arrays.sort(s1);
      Arrays.sort(s2);
      String t1 = new String(s1);
      String t2 = new String(s2);
      System.out.println(t2);
      if (t1.equals(t2) || tmp.equals(t2)) {
        ans.set(i, "-1");
        tmp = t2;
        continue;
      }
      if (!t1.equals(t2) && !tmp.equals(t2)) {
        tmp = t2;
        continue;
      }
    }
    Iterator<String> iterator = ans.iterator();
    while (iterator.hasNext()) {
      String i = iterator.next();
      if ("-1".equals(i)) {
        iterator.remove();
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    // WCompetition293_1 w = new WCompetition293_1();
    // String[] words = { "a", "b", "a" };
    // System.out.println(w.removeAnagrams(words));
    String c = "134";
    String a = new String(c);
    String b = new String(c);
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    System.out.println(c.hashCode());
    c = "135";
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    System.out.println(c.hashCode());

  }
}
