package com.dixiao.leetcode;

import java.util.Iterator;

/**
 * Created by di on 3/24/16.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer next;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        findNext();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ret = next;
        findNext();
        return ret;
    }

    private void findNext() {
        next = iterator.hasNext() ? iterator.next() : null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
