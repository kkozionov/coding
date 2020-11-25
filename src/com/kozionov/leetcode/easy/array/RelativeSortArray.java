package com.kozionov.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 */
public class RelativeSortArray {

    /**
     * Runtime: 1 ms, faster than 58.91% of Java online submissions for Relative Sort Array.
     * Memory Usage: 39 MB, less than 72.15% of Java online submissions for Relative Sort Array.
     */
    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, ArrayList<Integer>> index = new HashMap<>();
            int[] out = new int[arr1.length];

            for(int i = 0; i < arr1.length; i++) {
                int value = arr1[i];

                ArrayList<Integer> ind = index.get(value);
                if (ind == null) {
                    ind = new ArrayList<>();
                }

                ind.add(i);
                index.put(value, ind);
            }

            int k = 0;
            for (int value : arr2) {
                ArrayList<Integer> ind = index.get(value);
                for (Integer integer : ind) {
                    out[k++] = arr1[integer];
                }
                index.put(value, null);
            }

            int kk = k;
            for (int j : arr1) {
                if (index.get(j) != null) {
                    out[k++] = j;
                }
            }


            Arrays.sort(out, kk, out.length);

            return out;
        }
    }
}
