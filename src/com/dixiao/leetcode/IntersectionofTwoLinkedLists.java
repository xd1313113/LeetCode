package com.dixiao.leetcode;

import com.dixiao.model.ListNode;
import com.dixiao.utils.Utils;
import org.junit.Test;

/**
 * Created by di on 3/24/16.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        if (len1 >= len2) {
            int diff = len1 - len2;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            int diff = len2 - len1;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        getIntersectionNode(Utils.buildLinkedList("1,3,5,7,9,11,13,15,17,19,21"),Utils.buildLinkedList("2"));
    }
}

