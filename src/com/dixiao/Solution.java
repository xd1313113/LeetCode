package com.dixiao;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by di on 2/16/16.
 */
public class Solution {
    //balance point
    public int solutionForBalancePoint(int[] A) {
        // write your code in Java SE 8
        long[] sumA = new long[A.length];
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sumA[i] = (i == 0 ? 0 : sumA[i - 1]) + A[i];
        }

        for (int i = 0; i < A.length; i++) {
            long sumLeft = (i - 1 >= 0 ? sumA[i - 1] : 0);
            long sumRight = (i + 1 < A.length ? sumA[A.length - 1] - sumA[i] : 0);
            if (sumLeft == sumRight)
                return i;
        }
        return -1;
    }

    public int solutionForBinaryGap(int N) {
        // write your code in Java SE 8
        int max = 0, count = 0;

        while (N > 0) {
            if ((N & 1) == 1) {
                break;
            }
            N = N >> 1;
        }

        while (N > 0) {
            if ((N & 1) == 0) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }
            N = N >> 1;
        }
        return max;
    }

    public int[] solutionForCyclicRotation(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length == 0) return A;
        int tmp = 0;
        K = K % A.length;
        while (K-- > 0) {
            tmp = A[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                A[i + 1] = A[i];
            }
            A[0] = tmp;
        }
        return A;
    }


    public int solutionFor(int[] A) {
        if (A.length == 0) return 0;
        // write your code in Java SE 8
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    max = Math.max(max, dp[i -j]);
                }
            }
            dp[i] = A[i] + max;
        }
        return dp[A.length - 1];
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, helper(A, i));
        }
        return max;
    }

    public int helper(int[] A, int pos) {
        if (A[pos] >= 0){
            int nextPos = A[pos];
            A[pos] = -1;
            return 1 + helper(A, nextPos);
        }
        return 0;
    }

    public boolean solutionA(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 1) return true;
        int wrongPos = -1;
        int swapPos = -1;

        for (int i = 1; i < A.length; i++) {
            // look for first wrong pos
            if (wrongPos < 0) {
                if (A[i] < A[i -1]) {
                    wrongPos = i - 1;
                }
            } else {
                // looking for swap position
                if (A[i] > A[wrongPos]) {
                    swapPos = i - 1;
                    break;
                }
                swapPos = i;
            }
        }

        // if wrongPos and swapPos is valid, swap
        if (wrongPos >= 0 && swapPos >= 0)
            swap(A, wrongPos, swapPos);

        // validate if the array is sorted after swap.
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i -1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

//    @Test
//    public void test() {
//        //System.out.println(solutionForBalancePoint(new int[]{0, -2147483648, -2147483648}));
//        //System.out.println(solutionForBinaryGap(0b10010000));
//        //System.out.println(solution(new int[]{5,4,0,3,1,6,2}));
//
//        System.out.println(solution(new int[]{0}));
//        System.out.println(solutionA(new int[]{6,2,3,5,1}));
//
//    }

    static int longest_chain(String[] w) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (String s: w) {
            dict.put(s, -1);
        }

        int max = 0;
        for (String s : dict.keySet()) {
            max = Math.max(max, findChain(s, dict));
        }
        return max;
    }

    static int findChain(String s, HashMap<String, Integer> dict) {
        if (!dict.containsKey(s)){
            return 0;
        } else {
            if (dict.get(s) >= 0) {
                return 1 + dict.get(s);
            } else {
                int max = 0;
                for (int i = 0; i < s.length(); i++) {
                    String newWord = s.substring(0, i) + s.substring(i + 1);
                    max = Math.max(max, findChain(newWord, dict));
                }
                dict.put(s, max);
                return max + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
        int res;

        int _w_size = 0;
        _w_size = Integer.parseInt(in.nextLine());
        String[] _w = new String[_w_size];
        String _w_item;
        for(int _w_i = 0; _w_i < _w_size; _w_i++) {
            try {
                _w_item = in.nextLine();
            } catch (Exception e) {
                _w_item = null;
            }
            _w[_w_i] = _w_item;
        }

        res = longest_chain(_w);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }


}
