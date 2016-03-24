package com.dixiao.leetcode;

import com.dixiao.model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by di on 2/24/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        String path = "";
        dfs(root, res, path);
        return res;
    }

    private void dfs(TreeNode node, List<String> res, String path) {
        if (node.left == null && node.right == null) {
            res.add(path + node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, res, path + node.val + "->");
            }

            if (node.right != null) {
                dfs(node.right, res, path + node.val + "->");
            }
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node5;

        System.out.printf(binaryTreePaths(root).toString());

    }
}
