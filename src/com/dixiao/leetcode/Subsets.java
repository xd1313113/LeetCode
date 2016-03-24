package com.dixiao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by di on 3/6/16.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
     }

    private void helper(int[] nums,int pos, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helperDup(nums, 0 , new ArrayList<>(), res);
        return res;
    }

    private void helperDup(int[] nums,int pos, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i]  == nums[i - 1]) continue;
            path.add(nums[i]);
            helperDup(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsK(int[] nums, int K) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helperK(nums, 0, K, new ArrayList<>(), res);
        return res;
    }

    private void helperK(int[] nums,int pos, int K, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == K) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            helperK(nums, i + 1, K, path, res);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[] {1,2,3}));
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
        System.out.println(subsetsK(new int[] {1,2,3}, 3));
    }
}
