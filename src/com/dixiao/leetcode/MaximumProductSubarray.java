package com.dixiao.leetcode;

/**
 * Created by di on 3/9/16.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int localMax = nums[0];
        int localMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = localMax;
            localMax = Math.max(localMin * nums[i], Math.max(localMax * nums[i], nums[i]));
            localMin = Math.min(localMin * nums[i], Math.min(tmp * nums[i], nums[i]));;
            res = Math.max(localMax, res);
        }
        return res;
    }
}
