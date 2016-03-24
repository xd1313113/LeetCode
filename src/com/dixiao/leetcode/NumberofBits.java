package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/5/16.
 */
public class NumberofBits {
    public int hammingWeight(long n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(2147483648L));
    }
}
