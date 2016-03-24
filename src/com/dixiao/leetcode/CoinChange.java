package com.dixiao.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by di on 2/17/16.
 */
public class CoinChange {
    //dp
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for (Integer coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // recursive
    // Time exceeded on leetcode
    public int coinChange2(int[] coins, int amount) {
        int res = coinChangeRecursive(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            if (amount >= coin) {
                int locaRes = coinChangeRecursive(coins, amount - coin);
                if (locaRes != Integer.MAX_VALUE) {
                    res = Math.min(res, locaRes) + 1;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(coinChangeRecursive(new int[]{1,2,5}, 11));
    }
}
