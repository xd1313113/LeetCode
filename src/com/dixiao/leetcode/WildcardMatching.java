package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/2/16.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {

        int i = 0;
        int j = 0;
        int star = -1;
        int starMatch = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                star = j;
                starMatch = i;
                j++;
            } else if (star != -1) {
                j = star + 1;
                starMatch++;
                i = starMatch;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

    //dp
    public boolean isMatchDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length();i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else if (i == 0) {
                    int k = j;
                    dp[i][j] = true;
                    while(k > 0) {
                        if (p.charAt(k - 1) != '*') {
                            dp[i][j] = false;
                            break;
                        }
                        k--;
                    }
                } else {

                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        int cur = i;
                        while (cur > 0) {
                            if (dp[cur][j - 1]) {
                                dp[i][j] = true;
                                break;
                            }
                            cur--;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


        @Test
    public void test() {
        //isMatch("a", "aa");
        isMatch("acbcb", "a*b");
        //isMatchDP("aa", "*");
    }
}
