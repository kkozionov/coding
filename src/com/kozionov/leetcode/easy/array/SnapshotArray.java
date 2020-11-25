package com.kozionov.leetcode.easy.array;

import java.util.HashMap;

/**
 * Implement a SnapshotArray that supports the following interface:
 * <p>
 * SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */

/**
 * Runtime: 41 ms, faster than 28.66% of Java online submissions for Snapshot Array.
 * Memory Usage: 64.2 MB, less than 82.99% of Java online submissions for Snapshot Array.
 */
public class SnapshotArray implements SnapshotArrayInterface {
    static private final int IDX = -1;

    int snap_id = IDX;
    int size = 0;
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    public SnapshotArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        this.size = size;
        map.put(snap_id, new HashMap<>());
    }

    public void set(int index, int val) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }

        HashMap<Integer, Integer> current = map.get(IDX);

        current.put(index, val);
        map.put(IDX, current);
    }

    public int snap() {
        snap_id++;
        HashMap<Integer, Integer> current = map.get(IDX);
        map.put(snap_id, (HashMap<Integer, Integer>) current.clone());

        return snap_id;
    }

    public int get(int index, int snap_id) {
        if (snap_id < 0 || snap_id > this.snap_id) {
            throw new IllegalArgumentException("Incorrect snap_id");
        }

        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }

        Integer jj = map.get(snap_id).get(index);
        return jj == null ? 0 : jj;
    }
}
