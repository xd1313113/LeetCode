package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/24/16.
 */
public class SingleNumber {
    public int[] singleNumber3(int[] nums) {
        int xor = 0;
        for (Integer i : nums) {
            xor ^= i;
        }
        int lastBit = xor - (xor & (xor - 1));
        int A = 0, B = 0;
        for (Integer i : nums) {
            if ((i & lastBit) == 0) {
                A ^= i;
            } else {
                B ^= i;
            }
        }
        int[] res = new int[2];
        res[0] = A;
        res[1] = B;
        return res;
    }

    @Test
    public void test() {
        singleNumber3(new int[]{0, 0, 1, 2});
    }
}
