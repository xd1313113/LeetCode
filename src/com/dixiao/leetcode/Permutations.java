package com.dixiao.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by di on 3/6/16.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (Integer i : nums) {
            if (!path.contains(i)) {
                path.add(i);
                helper(nums, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helperUnique(nums, new boolean[nums.length], new ArrayList<>(), res);

        return res;
    }

    private void helperUnique(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && visited[i - 1] && nums[i] == nums[i - 1])
                continue;
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                helperUnique(nums, visited, path, res);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1,2,3}));
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
