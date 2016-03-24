package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/16/16.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;

        boolean negative = false;
        int i = 0;
        long res = 0;
        if (str.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
            } else {
                break;
            }
            if (res > Integer.MAX_VALUE)
                break;
        }

        if (negative)
            res = -res;

        if (res >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("9223372036854775809"));
    }
}
