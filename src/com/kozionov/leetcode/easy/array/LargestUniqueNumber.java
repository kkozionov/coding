package com.kozionov.leetcode.easy.array;

import java.util.HashMap;

/**
 * Given an array of integers A, return the largest integer that only occurs once.
 *
 * If no integer occurs once, return -1.
 */
public class LargestUniqueNumber {

    /**
     * Runtime: 3 ms, faster than 66.98% of Java online submissions for Largest Unique Number.
     * Memory Usage: 39 MB, less than 14.51% of Java online submissions for Largest Unique Number.
     */
    class Solution {
        public int largestUniqueNumber(int[] A) {
            HashMap<Integer, Integer> index = new HashMap<>();

            for (int i : A) {
                index.put(i, index.getOrDefault(i, 0) + 1);
            }

            int max = -1;
            for (int k : index.keySet()) {
                int v = index.get(k);
                if (v == 1 && k >= max) {
                    max = k;
                }
            }

            return max;
        }
    }
}
