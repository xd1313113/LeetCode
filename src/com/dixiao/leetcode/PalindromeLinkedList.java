package com.dixiao.leetcode;

import com.dixiao.model.ListNode;
import com.dixiao.utils.Utils;
import org.junit.Test;

/**
 * Created by di on 3/15/16.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);
        fast = head;
        while (reversed != null && fast != null) {
            if (reversed.val != fast.val)
                return false;
            reversed = reversed.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(Utils.buildLinkedList("0,0")));
    }
}
