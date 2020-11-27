package com.kozionov.leetcode.easy;

/**
 * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
 *
 * A majority element is an element that appears more than N/2 times in an array of length N.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 * Output: true
 * Explanation:
 * The value 5 appears 5 times and the length of the array is 9.
 * Thus, 5 is a majority element because 5 > 9/2 is true.
 * Example 2:
 *
 * Input: nums = [10,100,101,101], target = 101
 * Output: false
 * Explanation:
 * The value 101 appears 2 times and the length of the array is 4.
 * Thus, 101 is not a majority element because 2 > 4/2 is false.
 */
public class IsMajorityElement {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.
     * Memory Usage: 38.3 MB, less than 79.74% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.
     */
    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            if (nums.length == 0) {
                return false;
            }


            int e = (int) nums.length / 2;

            int cur = nums[0];
            int cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (cur == nums[i]) {
                    cnt++;

                    if (cnt > e) {
                        return true;
                    }
                } else {
                    if (i > e) {
                        return false;
                    }

                    cnt = 1;
                    cur = nums[i];
                }
            }

            return false;

        }
    }
}
