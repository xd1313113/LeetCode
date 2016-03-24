package com.dixiao.leetcode;

/**
 * Created by di on 3/6/16.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || G <= A) return (C - A) * (D - B) + (G - E) * (H - F);
        if (D <= F || H <= B) return (C - A) * (D - B) + (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int btm = Math.max(B, F);
        return (G-E)*(H-F) + (C-A)*(D-B) - (right - left) * (top - btm);
    }
}
