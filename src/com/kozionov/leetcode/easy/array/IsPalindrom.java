package com.kozionov.leetcode.easy.array;

import java.util.ArrayList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class IsPalindrom {

    public class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 1 ms, faster than 94.73% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 45.8 MB, less than 5.27% of Java online submissions for Palindrome Linked List.
     */
    class Solution {
        ListNode currentHead = null;

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            currentHead = head;
            return goDeep(head.next);

        }

        public boolean goDeep(ListNode tail) {
            if (tail == null) {
                return true;
            }

            if (!goDeep(tail.next)) {
                return false;
            }

            if (currentHead.val != tail.val) {
                return false;
            }

            currentHead = currentHead.next;
            return true;
        }
    }

    /**
     * Runtime: 2 ms, faster than 35.74% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 43 MB, less than 27.05% of Java online submissions for Palindrome Linked List.
     */
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            ArrayList<Integer> ar = new ArrayList<>();
            while(head != null) {
                ar.add(head.val);
                head = head.next;
            }


            int i = 0, j = ar.size() - 1;
            while(i < j) {
                if(!ar.get(i).equals(ar.get(j))) {
                    return false;
                }

                i++;
                j--;
            }
            return true;
        }

    }
}
