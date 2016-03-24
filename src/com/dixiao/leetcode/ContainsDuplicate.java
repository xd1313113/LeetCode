package com.dixiao.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by di on 2/27/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
