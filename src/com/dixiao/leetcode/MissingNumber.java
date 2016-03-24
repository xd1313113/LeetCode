package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/24/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }

        if (xor != 0)
            return xor ^ i;
        return i;
    }

    @Test
    public void test(){
        System.out.println(missingNumber(new int[]{0,1,3}));
    }
}
