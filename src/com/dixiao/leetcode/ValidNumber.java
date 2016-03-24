package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/29/16.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0;
        boolean dot = false;
        boolean exp = false;
        boolean valid = false;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        while (i < s.length()) {
            char c = s.charAt(i);
            if(c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || !valid) return false;
                exp = true;
                valid = false;
            } else if (c >= '0' && c <= '9') {
                valid = true;
            } else if (c == '+' || c == '-'){
                if (s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
            i++;
        }
        return valid;
    }

    @Test
    public void test() {
        isNumber(". 1");
    }
}
