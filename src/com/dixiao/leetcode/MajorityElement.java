package com.dixiao.leetcode;

/**
 * Created by di on 2/27/16.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorIndex = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majorIndex = i;
                count++;
            } else {
                if (nums[i] == nums[majorIndex]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return nums[majorIndex];
    }
}
