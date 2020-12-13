package com.kozionov.leetcode.easy;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapitalUse {

    /**
     * Runtime: 1 ms, faster than 99.31% of Java online submissions for Detect Capital.
     * Memory Usage: 37.6 MB, less than 34.41% of Java online submissions for Detect Capital.
     */
    class Solution {
        public boolean detectCapitalUse(String word) {
            char [] h = word.toCharArray();

            int capital = 0;
            for (char c : h) {
                capital = isCap(c) ? capital + 1 : capital;
            }

            if (capital == h.length) {
                return true;
            }

            if (isCap(h[0]) && capital == 1) {
                return true;
            }

            return !isCap(h[0]) && capital == 0;
        }

        public boolean isCap(char s) {
            int dd = s - 'A';
            return dd >= 0 && dd <= 26;
        }
    }
}
