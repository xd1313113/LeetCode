package com.dixiao.leetcode;

import java.util.HashMap;

/**
 * Created by di on 2/29/16.
 */
public class LRUCache {

    class CacheNode {
        public int key;
        public int val;
        public CacheNode pre;
        public CacheNode next;
        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, CacheNode> map;
    CacheNode head;
    CacheNode tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            removeNode(node);
            setToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void removeNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void setToHead(CacheNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.val = value;
            removeNode(node);
            setToHead(node);
        } else {
            CacheNode newNode = new CacheNode(key, value);
            map.put(key, newNode);
            if (size >= capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            setToHead(newNode);
            size++;
        }
    }

}
