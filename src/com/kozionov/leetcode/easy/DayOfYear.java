package com.kozionov.leetcode.easy;

/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 *
 *
 *
 * Example 1:
 *
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * Example 2:
 *
 * Input: date = "2019-02-10"
 * Output: 41
 * Example 3:
 *
 * Input: date = "2003-03-01"
 * Output: 60
 * Example 4:
 *
 * Input: date = "2004-03-01"
 * Output: 61
 */
public class DayOfYear {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Day of the Year.
     * Memory Usage: 37.1 MB, less than 82.28% of Java online submissions for Day of the Year.
     */
    class Solution {
        public int dayOfYear(String date) {
            int [] m = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};



            char [] dateChar = date.toCharArray();
            int year = ((int) dateChar[0]- '0') * 1000 + ((int) dateChar[1]- '0') * 100 + ((int) dateChar[2]- '0') * 10 + ((int) dateChar[3]- '0');
            int month = ((int) dateChar[5]- '0') * 10 + ((int) dateChar[6]- '0');
            int day = ((int) dateChar[8]- '0') * 10 + ((int) dateChar[9]- '0');

            if(year % 4 == 0 && year % 100 != 0) {
                m[1] = 29;
            }

            int dd = 0;

            for (int i = 0; i < month - 1; i++) {
                dd+=m[i];
            }

            dd+=day;

            return dd;

        }


    }
}
