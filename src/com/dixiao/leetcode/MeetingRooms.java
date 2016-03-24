package com.dixiao.leetcode;

import com.dixiao.model.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by di on 3/15/16.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start)
                return false;
        }
        return true;
    }


    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (Interval i : intervals) {
            if (minHeap.size() == 0) {
                minHeap.add(i.end);
                count++;
                continue;
            }

            if (minHeap.peek() > i.start) {
                minHeap.add(i.end);
                count++;
            } else {
                minHeap.poll();
                minHeap.add(i.end);
            }
        }
        return count;
    }
}
