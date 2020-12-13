package com.kozionov.leetcode.easy.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (p.left == q || p.right == q) {
            return p;
        }

        if (q.left == p || q.right == p) {
            return q;
        }

        ArrayList<TreeNode> levelsP = new ArrayList<>();
        traverse(root, p.val, levelsP);

        ArrayList<TreeNode> levelsQ = new ArrayList<>();
        traverse(root, q.val, levelsQ);

        ArrayList<TreeNode> min = levelsP.size() > levelsQ.size() ? levelsQ : levelsP;

        for (int i = min.size() - 1; i >= 0; i--) {
            if (levelsP.get(i).val == levelsQ.get(i).val) {
                return levelsP.get(i);
            }
        }

        return null;
    }

    public void traverse(TreeNode current, int value, ArrayList<TreeNode> levels) {
        if (current != null) {
            levels.add(current);

            if (current.val == value) {
                return;
            }

            if (current.val < value) {
                traverse(current.right, value, levels);
            } else {
                traverse(current.left, value, levels);
            }
        }
    }

    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 40.2 MB, less than 15.27% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     */
    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return root;
            }

            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p,q);
            } else if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p,q);
            } else {
                return root;
            }
        }
    }
}
