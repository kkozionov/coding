package com.kozionov.leetcode.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SymmetricTree {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    /**
     * 0 ms	37.6 MB
     */
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return test(root.left, root.right);

        }

        public boolean test(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val == right.val) {
                return test(left.left, right.right) && test(left.right, right.left);
            } else {
                return false;
            }
        }
    }

    /**
     * 1 ms	39.2 MB
     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            q.add(root);

            while(!q.isEmpty()) {
                TreeNode a = q.poll();
                TreeNode b = q.poll();

                if (a == null && b == null) continue;
                if ((a == null || b == null) || (a.val != b.val)) {
                    return false;
                }

                q.add(a.left);
                q.add(b.right);
                q.add(a.right);
                q.add(b.left);
            }

            return true;
        }
    }
}
