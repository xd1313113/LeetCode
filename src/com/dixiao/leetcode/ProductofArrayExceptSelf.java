package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/6/16.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) return res;
        int tmp = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            tmp *= nums[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
}
