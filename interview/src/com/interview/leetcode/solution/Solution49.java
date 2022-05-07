package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *  
 * 
 * 提示：
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 */
public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    int len = strs.length;
    for (int i = 0; i < len; i++) {
      char[] tmp = strs[i].toCharArray();
      Arrays.sort(tmp);
      String key = new String(tmp);
      List<String> val = map.getOrDefault(key, new ArrayList<>());
      val.add(strs[i]);
      map.put(key, val);
    }
    for (List<String> item : map.values()) {
      ans.add(item);
    }
    return ans;

  }

  public static void main(String[] args) {
    Solution49 solution49 = new Solution49();
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(solution49.groupAnagrams(strs));
  }
}
