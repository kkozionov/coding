package com.kozionov.leetcode.easy;

import java.util.HashMap;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */
public class CountCharacters {

    /**
     * Runtime: 59 ms, faster than 8.72% of Java online submissions for Find Words That Can Be Formed by Characters.
     * Memory Usage: 39.8 MB, less than 16.68% of Java online submissions for Find Words That Can Be Formed by Characters.
     */
    class Solution1 {
        public int countCharacters(String[] words, String chars) {
            int sum = 0;

            for (String word : words) {
                char [] letters = word.toCharArray();

                int ll = 0;
                HashMap<Character, Integer> charMap = charMap(chars);

                for(char letter : letters) {
                    Integer count = charMap.get(letter);

                    if (count != null && count > 0) {
                        ll++;
                        charMap.put(letter, --count);
                    }
                }

                if (ll == word.length()) {
                    sum+=ll;
                }
            }

            return sum;
        }

        public HashMap<Character, Integer> charMap(String chars) {
            HashMap<Character, Integer> out = new HashMap<>();
            for (char c : chars.toCharArray()) {
                out.put(c, out.getOrDefault(c, 0) + 1);
            }

            return out;
        }
    }

    /**
     * Runtime: 14 ms, faster than 42.16% of Java online submissions for Find Words That Can Be Formed by Characters.
     * Memory Usage: 39.6 MB, less than 44.68% of Java online submissions for Find Words That Can Be Formed by Characters.
     */
    class Solution2 {
        public int countCharacters(String[] words, String chars) {
            int sum = 0;

            for (String word : words) {
                char [] letters = word.toCharArray();

                int ll = 0;
                int[] charMap = charMap(chars);

                for(char letter : letters) {
                    int count = charMap[letter - 'a'];

                    if (count > 0) {
                        ll++;
                        charMap[letter - 'a']--;
                    }
                }

                if (ll == word.length()) {
                    sum+=ll;
                }
            }

            return sum;
        }

        public int[] charMap(String chars) {
            int[] out = new int[26];
            for (char c : chars.toCharArray()) {
                out[c - 'a']++;
            }

            return out;
        }
    }

    /**
     * Runtime: 9 ms, faster than 61.82% of Java online submissions for Find Words That Can Be Formed by Characters.
     * Memory Usage: 39.6 MB, less than 44.68% of Java online submissions for Find Words That Can Be Formed by Characters.
     */
    class Solution3 {
        public int countCharacters(String[] words, String chars) {
            int sum = 0;
            int[] charMap = charMap(chars);

            for (String word : words) {
                int [] letters = charMap(word);

                int ll = 0;
                for(int i = 0; i < 26; i++) {
                    if (letters[i] != 0 && letters[i] <= charMap[i]) {
                        ll+=letters[i];
                    }
                }

                if (ll == word.length()) {
                    sum+=ll;
                }
            }

            return sum;
        }

        public int[] charMap(String chars) {
            int[] out = new int[26];
            for (char c : chars.toCharArray()) {
                out[c - 'a']++;
            }

            return out;
        }
    }
}
