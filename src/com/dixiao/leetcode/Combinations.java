package com.dixiao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 3/9/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void helper(int n, int k, int depth, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = depth; i <= n; i++) {
            path.add(i);
            helper(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        combine(4, 2);
    }

}
