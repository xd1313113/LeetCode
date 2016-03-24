package com.dixiao.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by di on 3/5/16.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            if (!set.add(next)) {
                return false;
            }
            n = next;
        }
        return true;
    }

    @Test
    public void test () {
        isHappy(19);
    }

}
