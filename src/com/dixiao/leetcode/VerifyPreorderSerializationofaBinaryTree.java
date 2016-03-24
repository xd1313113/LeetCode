package com.dixiao.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by di on 2/18/16.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return false;
        List<String> s = new LinkedList<>();
        for (String c : preorder.split(",")) {
            s.add(c);
            while (s.size() >= 3 && s.get(s.size() - 1).equals("#") && s.get(s.size() - 2).equals("#") && !s.get(s.size() - 3).equals("#")) {
                s = s.subList(0, s.size() - 3);
                s.add("#");
            }
        }

        return s.size() == 1 && s.get(0).equals("#");
    }

    @Test
    public void test() {
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
