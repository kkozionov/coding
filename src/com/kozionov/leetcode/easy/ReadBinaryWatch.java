package com.kozionov.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.
 */
public class ReadBinaryWatch {
    /**
     * Runtime: 9 ms, faster than 60.77% of Java online submissions for Binary Watch.
     * Memory Usage: 38.3 MB, less than 58.35% of Java online submissions for Binary Watch.
     */
    class Solution {
        public List<String> readBinaryWatch(int num) {
            ArrayList<String> res = new ArrayList<>();

            for(int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                        res.add(h + ":" + (m >= 10 ? m : "0" + m) );
                    }
                }
            }

            return res;
        }
    }
}
