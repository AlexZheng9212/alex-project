
package com.interview.leetcode;

import java.util.*;

import com.interview.leetcode.datastruct.ListNode;

class Solution147 {
    ListNode res;

    public ListNode insertionSortList(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }

        // Collections.sort(ans);
        List<Integer> temp = reorder(ans);

        for (int i = 0; i < temp.size(); i++) {
            if (res == null) {
                res = new ListNode(temp.get(i));
                continue;
            }
            ListNode cur = res;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(temp.get(i));
        }
        return res;
    }

    private List<Integer> reorder(List<Integer> list) {
        List<Integer> reoder = new ArrayList<>();
        for (int i = 0; i < (list.size() + 1) / 2; i += 2) {
            if ((i + 1) % 2 != 0) {
                reoder.add(i);
                reoder.add(list.size() - i - 1);
            }
        }
        return reoder;
    }
}