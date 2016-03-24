package com.dixiao.leetcode;

import com.dixiao.model.ListNode;

/**
 * Created by di on 3/5/16.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode pre = head, cur = head.next;

        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;

        }
        return head;
    }
}
