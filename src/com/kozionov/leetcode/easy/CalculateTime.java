package com.kozionov.leetcode.easy;

/**
 * There is a special keyboard with all keys in a single row.
 *
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 *
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 *
 *
 *
 * Example 1:
 *
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4.
 * Example 2:
 *
 * Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * Output: 73
 */
public class CalculateTime {

    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Single-Row Keyboard.
     * Memory Usage: 39 MB, less than 46.34% of Java online submissions for Single-Row Keyboard.
     */
    class Solution {
        public int calculateTime(String keyboard, String word) {

            int [] kk = new int[26];

            char [] ll = keyboard.toCharArray();
            for(int i = 0; i < 26; i++) {
                kk[ll[i]- 'a'] = i;
            }

            int pos = 0;
            int path = 0;
            char [] wordAsChar = word.toCharArray();
            for (char c : wordAsChar) {
                int charPos = c - 'a';
                path += Math.abs(kk[charPos] - pos);
                pos = kk[charPos];
            }

            return path;
        }
    }
}
