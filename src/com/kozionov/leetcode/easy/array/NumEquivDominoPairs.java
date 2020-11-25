package com.kozionov.leetcode.easy.array;

import java.util.HashMap;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class NumEquivDominoPairs {

    /**
     * Runtime: 20 ms, faster than 25.62% of Java online submissions for Number of Equivalent Domino Pairs.
     * Memory Usage: 48.5 MB, less than 41.60% of Java online submissions for Number of Equivalent Domino Pairs.
     */
    class Solution {

        public int numEquivDominoPairs(int[][] dominoes) {

            HashMap<String, Integer> index = new HashMap<>();

            for (int [] p : dominoes) {
                String k = Math.min(p[0], p[1]) + "" + Math.max(p[0], p[1]);

                index.put(k, index.getOrDefault(k, 0) + 1);
            }

            int out = 0;
            for (Integer v : index.values()) {
                out+=v*(v-1)/2;
            }

            return out;
        }
    }
}
