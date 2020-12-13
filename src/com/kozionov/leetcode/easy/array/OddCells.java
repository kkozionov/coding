package com.kozionov.leetcode.easy.array;

/**
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * Example 2:
 *
 *
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 */
public class OddCells {
    /**
     * Runtime: 2 ms, faster than 23.89% of Java online submissions for Cells with Odd Values in a Matrix.
     * Memory Usage: 37 MB, less than 60.40% of Java online submissions for Cells with Odd Values in a Matrix.
     */
    class Solution {
        public int oddCells(int n, int m, int[][] indices) {
            if (n == 0 || m == 0) {
                return 0;
            }

            int [][] me = new int[n][m];
            int cnt = 0;
            for (int i = 0; i < indices.length; i++) {

                for (int ii = 0; ii < m; ii++) {
                    me[indices[i][0]][ii]++;
                }

                for (int ii = 0; ii < n; ii++) {
                    me[ii][indices[i][1]]++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (me[i][j] % 2 != 0) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Cells with Odd Values in a Matrix.
     * Memory Usage: 37.2 MB, less than 22.72% of Java online submissions for Cells with Odd Values in a Matrix.
     */
    class Solution1 {
        public int oddCells(int n, int m, int[][] indices) {
            if (n == 0 || m == 0) {
                return 0;
            }


            int cnt = 0;
            int [] rows = new int [n];
            int [] cols = new int [m];
            for (int[] index : indices) {
                rows[index[0]]++;
                cols[index[1]]++;
                }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((rows[i] + cols[j]) % 2 != 0) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }
}
