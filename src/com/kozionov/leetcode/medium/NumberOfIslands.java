package com.kozionov.leetcode.medium;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    /**
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Number of Islands.
     * Memory Usage: 41.3 MB, less than 74.32% of Java online submissions for Number of Islands.
     */
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int cnt = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        // island has found
                        cnt++;
                        explore(grid, i, j);
                    }
                }
            }

            return cnt;

        }

        public void explore(char [][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
                return;
            }

            // visit island
            grid[i][j] = '0';

            explore(grid, i + 1, j);
            explore(grid, i - 1, j);
            explore(grid, i, j + 1);
            explore(grid, i, j - 1);
        }
    }
}
