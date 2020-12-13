package com.kozionov.leetcode.easy;

/**
 * Given an integer, return its base 7 string representation.
 */
public class ConvertToBase7 {

    /**
     * Runtime: 8 ms, faster than 17.23% of Java online submissions for Base 7.
     * Memory Usage: 37.2 MB, less than 16.17% of Java online submissions for Base 7.
     */
    class Solution {
        public String convertToBase7(int num) {
            if (num < 0) {
                return "-" + convertToBase7(-num);
            }

            if (num < 7) {
                return num + "";
            }

            return convertToBase7(num / 7) + "" + num % 7;
        }
    }

    /**
     * Runtime: 1 ms, faster than 85.53% of Java online submissions for Base 7.
     * Memory Usage: 36.7 MB, less than 26.81% of Java online submissions for Base 7.
     */
    class Solution1 {
        public String convertToBase7(int num) {

            StringBuffer str = new StringBuffer();
            boolean neg = num < 0;
            if (neg) {
                num = -num;
            }

            while(num >= 7) {
                str.append(num % 7);
                num = num / 7;
            }

            str.append(num);

            return neg ? "-" + str.reverse().toString() : str.reverse().toString();
        }
    }
}
