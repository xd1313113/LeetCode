package com.dixiao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by di on 3/23/16.
 */
public class ImplementStackusingQueues {
    // Push element x onto stack.
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!q1.isEmpty()) {
            moveQ1ToQ2();
        }
        q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Get the top element.
    public int top() {
        if (!q1.isEmpty()) {
            moveQ1ToQ2();
        }
        return q1.peek();
    }

    private void moveQ1ToQ2() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
