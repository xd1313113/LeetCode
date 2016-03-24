package com.dixiao.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by di on 3/1/16.
 */
public class FindMedianfromDataStream {
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((x, y) -> y - x);


    // Adds a number into the data structure.
    public void addNum(int num) {
        double median = findMedian();
        if (minQ.size() == maxQ.size()) {
            if (num > median) {
                minQ.add(num);
            } else {
                maxQ.add(num);
            }
        } else if (minQ.size() > maxQ.size()) {
            if (num > median) {
                minQ.add(num);
                maxQ.add(minQ.poll());
            } else {
                maxQ.add(num);
            }
        } else {
            if (num < median) {
                maxQ.add(num);
                minQ.add(maxQ.poll());
            } else {
                minQ.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minQ.size() == 0 && maxQ.size() == 0)
            return 0;
        if (minQ.size() == maxQ.size())
            return (double) (minQ.peek() + maxQ.peek()) / 2;
        else {
            return minQ.size() > maxQ.size() ? minQ.peek() : maxQ.peek();
        }
    }

    @Test
    public void test() {
        addNum(1);addNum(2);
        System.out.println(findMedian());
        addNum(3);
        System.out.println(findMedian());

    }
}
