package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/6/16.
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (i == j) return nums[i];
            if (j - i == 1) return Math.min(nums[i], nums[j]);
            if (nums[i] < nums[j]) return nums[i];

            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[i]) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }

    @Test
    public void test() {
        findMin(new int[] {4, 5, 6, 7, 0, 1, 2});
    }
}
