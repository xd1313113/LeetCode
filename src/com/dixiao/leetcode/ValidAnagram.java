package com.dixiao.leetcode;

import java.util.Arrays;

/**
 * Created by di on 2/27/16.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--chars[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
