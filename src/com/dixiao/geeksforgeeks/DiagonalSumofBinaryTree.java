package com.dixiao.geeksforgeeks;

import com.dixiao.leetcode.Codec;
import com.dixiao.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 3/15/16.
 */
public class DiagonalSumofBinaryTree {
    public List<Integer> diagonalSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }

    private void traverse(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth >= res.size()) {
            res.add(depth, node.val);
        } else {
            res.set(depth, node.val + res.get(depth));
        }
        traverse(node.left, depth + 1, res);
        traverse(node.right, depth, res);
    }

    @Test
    public void test() {
        Codec codec = new Codec();
        System.out.println(diagonalSum(codec.deserialize("0,1,4,null,null,5,7,null,null,null,2,3,null,null,6")));
    }
}
