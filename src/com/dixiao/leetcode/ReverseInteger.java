package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/16/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            x = x / 10;
        }
        if (Math.abs(res) > Integer.MAX_VALUE)
            return 0;
        return (int)res;
    }

    @Test
    public void test() {
        System.out.println(reverse(-123));
    }
}
