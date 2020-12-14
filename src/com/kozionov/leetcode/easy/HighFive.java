package com.kozionov.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.
 *
 * Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
 *
 * A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
 * The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
 * Example 2:
 *
 * Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
 * Output: [[1,100],[7,100]]
 */
public class HighFive {
    /**
     * Runtime: 4 ms, faster than 87.80% of Java online submissions for High Five.
     * Memory Usage: 39.5 MB, less than 51.10% of Java online submissions for High Five.
     */
    class Solution {
        public int[][] highFive(int[][] items) {
            HashMap<Integer, ArrayList<Integer>> scores = new HashMap<>();

            for (int [] pair : items) {
                ArrayList<Integer> values =
                        scores.getOrDefault(pair[0], new ArrayList<Integer>());
                values.add(pair[1]);
                scores.put(pair[0], values);
            }

            ArrayList<Integer> ids = new ArrayList<>();
            int keySize = 0;
            for(Integer key : scores.keySet()) {
                ids.add(key);
                keySize++;
                if (scores.get(key).size() > 5) {
                    Collections.sort(scores.get(key));
                }
            }

            Collections.sort(ids);

            int [][] res = new int[keySize][2];
            int resI = 0;
            for (int k : ids) {
                ArrayList<Integer> vals = scores.get(k);
                int avg = 0;
                for (int i = vals.size() - 1; i >= vals.size() - 5; i--) {
                    avg += vals.get(i);
                }

                avg = avg / 5;
                res[resI] = new int[]{k, avg};
                resI++;
            }

            return res;
        }
    }
}
