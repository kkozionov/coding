package com.kozionov.leetcode.easy;

/**
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 */
public class CountOdds {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Odd Numbers in an Interval Range.
     * Memory Usage: 35.6 MB, less than 86.59% of Java online submissions for Count Odd Numbers in an Interval Range.
     */
    class Solution {
        public int countOdds(int low, int high) {
            if (low%2 == 0 && high % 2 == 0) {
                return (high-low)/2;
            }

            if (low % 2 == 0) {
                return (high + 1 - low) / 2;
            }

            if (high % 2 == 0) {
                return (high - low - 1) / 2 + 1;
            }

            return (high - low)/2 + 1;
        }
    }
}
