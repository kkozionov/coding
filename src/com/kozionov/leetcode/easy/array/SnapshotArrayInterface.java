package com.kozionov.leetcode.easy.array;

public interface SnapshotArrayInterface {
    public void set(int index, int val);

    public int snap();

    public int get(int index, int snap_id);
}
