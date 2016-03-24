package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/16/16.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);
            if (temp.length() > longest.length())
                longest = temp;
            temp = helper(s, i, i + 1);
            if (temp.length() > longest.length())
                longest = temp;
        }
        return longest;
    }

    String helper(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindromeDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int index = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        index = i;
                    }
                }
            }
        }

        return s.substring(index, index + maxLen);
    }

    @Test
    public void test() {

    }

}
