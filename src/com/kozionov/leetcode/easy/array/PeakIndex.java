package com.kozionov.leetcode.easy.array;

/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 *
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 *
 */
public class PeakIndex {
    /**
     * 1 ms	39.7 MB
     *
     * Runtime: 1 ms, faster than 12.87% of Java online submissions for Peak Index in a Mountain Array.
     * Memory Usage: 39.7 MB, less than 69.54% of Java online submissions for Peak Index in a Mountain Array.
     */
    class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int iPeak = 0;
            int peak = A[iPeak];

            for(int i = 1; i < A.length; i++) {
                if (A[i] > peak) {
                    peak = A[i];
                    iPeak = i;
                } else if (peak < A[i]) {
                    return i;
                }
            }


            return iPeak;

        }
    }
}
