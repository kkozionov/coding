package com.kozionov.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 *
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 */
public class FindDiagonalOrder {

    /**
     * Runtime: 7 ms, faster than 22.31% of Java online submissions for Diagonal Traverse.
     * Memory Usage: 41.1 MB, less than 62.68% of Java online submissions for Diagonal Traverse.
     */
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int N = matrix.length, M = matrix[0].length;
            int [] t = new int[M*N];
            int cnt = 0;


            for (int d = 0; d < N + M - 1; d++) {
                Integer [] diag = traverse(matrix, d, d % 2 == 0);
                for (int i = 0; i < diag.length; i++) {
                    t[cnt++] = diag[i];
                }
            }


            return t;
        }

        public Integer[] traverse(int [][] m, int d, boolean isReverse) {
            int N = m.length, M = m[0].length;
            ArrayList<Integer> res = new ArrayList<>();

            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            while (r < N && c > -1) {

                res.add(m[r][c]);
                ++r;
                --c;
            }

            if (isReverse) {
                Collections.reverse(res);
            }

            Integer [] dd = new Integer[res.size()];
            dd = res.toArray(dd);
            return dd;
        }
    }
}
