package com.dixiao.leetcode;

import com.dixiao.model.TreeNode;

/**
 * Created by di on 2/25/16.
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        TreeNode l = lowestCommonAncestor(root.left, p , q);
        TreeNode r = lowestCommonAncestor(root.right, p , q);
        if (l != null && r != null) return root;
        return l != null ? l : r;
    }
}
