package com.dixiao.leetcode;

import com.dixiao.model.TreeNode;
import org.junit.Test;

/**
 * Created by di on 2/25/16.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        if (l < 0 || r < 0) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return 1 + Math.max(l, r);
    }

    @Test
    public void test() {
        System.out.println(isBalanced(new TreeNode(1)));
    }
}
