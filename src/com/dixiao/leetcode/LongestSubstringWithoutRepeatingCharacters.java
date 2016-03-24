package com.dixiao.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by di on 2/15/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] countTable = new int[256];
        Arrays.fill(countTable, -1);
        int start = -1;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (countTable[c] > start) {
                start = countTable[c];
            }
            maxLen = Math.max(maxLen, end - start);
            countTable[c] = end;
        }
        return maxLen;
    }

    @Test
    public void test() {
        lengthOfLongestSubstring("tmmzuxt");
    }
}
