package com.kozionov.leetcode.easy;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class DepthSum {

     public interface NestedInteger {
//         public NestedInteger();
//         public NestedInteger(int value);
         public boolean isInteger();
         public Integer getInteger();
         public void setInteger(int value);
         public void add(NestedInteger ni);
         public List<NestedInteger> getList();
  }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Nested List Weight Sum.
     * Memory Usage: 36.7 MB, less than 17.90% of Java online submissions for Nested List Weight Sum.
     */
    class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            int sum = 0;

            if (nestedList == null || nestedList.size() == 0) {
                return sum;
            }

            for (NestedInteger ni : nestedList) {
                sum += dSumm(ni, 1);
            }

            return sum;
        }

        public int dSumm(NestedInteger i, int depth) {
            if (i == null) {
                return 0;
            }

            if (i.isInteger()) {
                return depth * i.getInteger();
            }

            int sum = 0;
            for (NestedInteger ni : i.getList()) {
                sum+=dSumm(ni, depth+1);
            }

            return sum;
        }
    }
}
