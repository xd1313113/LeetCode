package com.dixiao.leetcode;

import com.dixiao.model.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by di on 2/10/16.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        buildString(root, res);
        return res.toString();
    }

    private void buildString(TreeNode node, StringBuilder res) {
        if (node == null) {
            res.append("null,");
        } else {
            res.append(node.val + ",");
            buildString(node.left, res);
            buildString(node.right, res);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(ArrayList<String> nodes) {
        if (nodes.size() == 0) return null;
        String val = nodes.remove(0);
        TreeNode node;
        if (val.equals("null")) {
            node = null;
        } else {
            node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
        }
        return node;
    }

    @Test
    public void test() {

        String res = serialize(deserialize("1,2,3,null,null,4,5,"));
    }
}
