package com.dixiao.leetcode;

import com.dixiao.model.TreeLinkNode;

/**
 * Created by di on 3/7/16.
 */
public class PopulatingNextRightPointersinEachNode {

    // perfect tree
    public void connectRecur(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;
        }
        connectRecur(root.left);
        connectRecur(root.right);
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        TreeLinkNode first = null;

        while (p != null) {
            if (first == null) {
                first = p.left;
            }

            if (p.left != null) {
                p.left.next = p.right;
            } else {
                break;
            }
            if (p.next != null) {
                p.right.next = p.next.left;
                p = p.next;
            } else {
                p = first;
                first = null;
            }
        }
    }

    // non perfect tree


    public void connect2(TreeLinkNode root) {
        TreeLinkNode p = root;
        TreeLinkNode first = null;
        TreeLinkNode last = null;

        while (p != null) {
            if (first == null) {
                if (p.left != null) {
                    first = p.left;
                } else {
                    first = p.right;
                }
            }

            if (p.left != null) {
                if (last != null) {
                    last.next = p.left;
                }
                last = p.left;
            }

            if (p.right != null) {
                if (last != null) {
                    last.next = p.right;
                }
                last = p.right;
            }

            if (p.next != null) {
                p = p.next;
            } else {
                p = first;
                first = null;
                last = null;
            }
        }
    }

    public void connect2Recur(TreeLinkNode root) {
        if (root == null) return;

    }


}
