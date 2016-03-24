package com.dixiao.leetcode;

import com.dixiao.model.ListNode;
import com.dixiao.utils.Utils;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.junit.Test;

/**
 * Created by di on 2/15/16.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), resCur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            resCur.next = new ListNode(sum);
            resCur = resCur.next;
        }

        if (carry > 0)
            resCur.next = new ListNode(carry);

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = Utils.buildLinkedList("0,");
        ListNode l2 = Utils.buildLinkedList("0,");
        addTwoNumbers(l1, l2);
    }
}
