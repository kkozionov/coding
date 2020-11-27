package com.kozionov.leetcode.easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbStairs {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 35.8 MB, less than 47.88% of Java online submissions for Climbing Stairs.
     */
    class Solution {
        public int climbStairs(int n) {
            if (n < 1) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }

            int [] steps = new int[n+1];
            steps[0] = 0;
            steps[1] = 1;
            steps[2] = 2;


            for (int i = 3; i <= n; i++) {
                steps[i] = steps[i-2] + steps[i-1];
            }

            return steps[n];
        }
    }
}
