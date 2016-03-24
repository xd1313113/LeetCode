package com.dixiao.utils;

import com.dixiao.model.ListNode;

/**
 * Created by di on 2/15/16.
 */
public class Utils {
    public static ListNode buildLinkedList(String s) {
        ListNode dummy = new ListNode(0), p = dummy;
        for (String val :s.split(",")) {
            p.next = new ListNode(Integer.valueOf(val));
            p = p.next;
        }
        return dummy.next;
    }
}
