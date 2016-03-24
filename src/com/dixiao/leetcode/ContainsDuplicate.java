package com.dixiao.leetcode;

import java.util.*;

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

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

}
