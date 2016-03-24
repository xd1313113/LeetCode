package com.dixiao.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by di on 2/15/16.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0) return 0;
        if (len % 2 == 0) {
            return (findKth(nums1, nums2, len / 2 - 1) + findKth(nums1, nums2, len / 2)) / 2;
        } else {
            return findKth(nums1, nums2, len / 2);
        }
    }

    public double findKth(int[] A, int[] B, int K) {
        if (A.length > B.length)
            return findKth(B, A, K);
        if (A.length == 0)
            return B[K];
        if (K == 0)
            return A[0] < B[0] ? A[0] : B[0];
        int a = Math.min(A.length, K / 2);
        int b = K - a;
        if (A[a] > B[b])
            return findKth(A, Arrays.copyOfRange(B, b, B.length), K - a);
        else if (A[a] < B[b])
            return findKth(Arrays.copyOfRange(A, a, A.length), B, K - b);
        else
            return A[a];

    }

    @Test
    public void test() {
        findMedianSortedArrays(new int[]{1,3,5}, new int[]{2,4});
    }
}
