package com.dixiao.leetcode;

/**
 * Created by di on 3/24/16.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    boolean isBadVersion(int pos) {
        return true;
    }
}
