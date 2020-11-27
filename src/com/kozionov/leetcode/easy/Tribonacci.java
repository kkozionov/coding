package com.kozionov.leetcode.easy;

import java.util.HashMap;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 */
public class Tribonacci {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
     * Memory Usage: 35.7 MB, less than 62.78% of Java online submissions for N-th Tribonacci Number.
     */
    class Solution {

        HashMap<Integer, Integer> cc = new HashMap<>();


        public int tribonacci(int n) {
            if (n < 0) {
                return 0;
            }

            if (n == 0) {
                return 0;
            }

            if (n == 2 || n == 1) {
                return 1;
            }


            return withCache(n-3) + withCache(n-2) + withCache(n-1);
        }

        public Integer withCache(int n) {
            Integer a = cc.get(n);
            if (a == null) {
                a = tribonacci(n);
                cc.put(n, a);
            }

            return a;
        }
    }
}
