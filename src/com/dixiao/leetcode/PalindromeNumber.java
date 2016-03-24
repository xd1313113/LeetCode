package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/16/16.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int divider = 1;
        while (x / divider >= 10) {
            divider *= 10;
        }

        while (x > 0) {
            int left = x / divider;
            int right = x % 10;
            if (left != right)
                return false;
            x = (x % divider) / 10;
            divider /= 100;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(100));
    }
}
