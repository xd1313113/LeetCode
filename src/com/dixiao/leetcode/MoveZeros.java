package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 2/26/16.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }


    @Test
    public void test() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
