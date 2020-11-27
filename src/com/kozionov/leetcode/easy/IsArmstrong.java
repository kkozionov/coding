package com.kozionov.leetcode.easy;

/**
 * The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.
 *
 * Given a positive integer N, return true if and only if it is an Armstrong number.
 */
public class IsArmstrong {

    /**
     * Runtime: 4 ms, faster than 5.71% of Java online submissions for Armstrong Number.
     * Memory Usage: 35.6 MB, less than 84.57% of Java online submissions for Armstrong Number.
     */
    class Solution {
        public boolean isArmstrong(int N) {

            String nn = "" + N;
            int a = 0;
            char [] c = nn.toCharArray();
            for (char n: c) {
                int d = (int) n - '0';
                a+= Math.pow(d,c.length);
            }

            return a == N;
        }
    }
}
