package com.kozionov.leetcode.easy;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 */
public class MaxNumberOfBalloons {

    /**
     * Runtime: 3 ms, faster than 47.48% of Java online submissions for Maximum Number of Balloons.
     * Memory Usage: 39.1 MB, less than 29.48% of Java online submissions for Maximum Number of Balloons.
     */
    class Solution {
        static final String WORD = "balloon";

        public int maxNumberOfBalloons(String text) {
            if (text == null || text.length() < 7) {
                return 0;
            }

            HashMap<Character, Integer> idx = new HashMap<>();

            for (char ch : text.toCharArray()) {
                if (WORD.indexOf(ch) >= 0) {
                    idx.put(ch, idx.getOrDefault(ch, 0) + 1);
                }
            }

            if (idx.values().size() != 5) {
                return 0;
            }

            int minFreq = idx.get('b');
            for (Integer a : idx.values()) {
                minFreq = minFreq >= a ? a : minFreq;
            }

            while(idx.get('l') < 2*minFreq || idx.get('o') < 2*minFreq) {
                minFreq--;
            }

            return minFreq;
        }
    }

    class Solution1 {
        static final String WORD = "balloon";

        public int maxNumberOfBalloons(String text) {
            if (text == null || text.length() < 7) {
                return 0;
            }

            int [] freq = new int[26];


            for (char ch : text.toCharArray()) {
                freq[ch - 'a'] = freq[ch - 'a'] + 1;
            }

            return IntStream.of(
                    freq['b' - 'a'],
                    freq[0],
                    freq['l' - 'a'] / 2,
                    freq['o' - 'a'] / 2,
                    freq['n' - 'a']
            ).min().getAsInt();
        }
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Number of Balloons.
     * Memory Usage: 38.7 MB, less than 58.10% of Java online submissions for Maximum Number of Balloons.
     */
    class Solution2 {
        public int maxNumberOfBalloons(String text) {
            if (text == null || text.length() < 7) {
                return 0;
            }

            int [] freq = new int[26];
            for (char ch : text.toCharArray()) {
                freq[ch - 'a'] = freq[ch - 'a'] + 1;
            }

            int min = freq['b' - 'a'];
            min = Math.min(freq[0], min);
            min = Math.min(freq['l' - 'a'] / 2, min);
            min = Math.min(freq['o' - 'a'] / 2, min);
            min = Math.min(freq['n' - 'a'], min);
            return min;
        }
    }
}
