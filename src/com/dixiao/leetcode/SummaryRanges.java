package com.dixiao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 3/24/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (start != nums[i]) {
                res.add(start + "->" + nums[i]);
            } else {
                res.add(String.valueOf(start));
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }
}
