package com.lex.leetcode.practice.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 简单
 *
 * @author lifeng
 */
public class PalindromeLinkList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val).append(" ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    /**
     * 遍历一次，确定链表个数
     * 找到分割点，然后逆序后半部分
     * 比较2个链表即可
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);
        ListNode h1c = h1, h2c = h2;

        int step = len / 2;
        boolean isOdd = len % 2 == 1;
        cur = head;
        while (cur != null) {
            if (step > 0) {
                h1c.next = cur;
                h1c = h1c.next;
            } else {
                if ((!isOdd) || step < 0) {
                    h2c.next = cur;
                    h2c = h2c.next;
                }
            }
            step--;
            cur = cur.next;
        }

        h1c.next = null;
        h2c.next = null;
        h2.next = reverse(h2.next);

        // merge
        h1c = h1.next;
        h2c = h2.next;
        while (h1c != null || h2c != null) {
            if (h1c == null || h2c == null) {
                return false;
            }
            if (h1c.val != h2c.val) {
                return false;
            }
            h1c = h1c.next;
            h2c = h2c.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = dummy.next, hnext = head.next;
            dummy.next = head;
            dummy.next.next = next;
            head = hnext;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            PalindromeLinkList solution = new PalindromeLinkList();
            ListNode l1 = new ListNode(1);
            ListNode l11 = new ListNode(2);
            l1.next = l11;
            // false
            System.out.println(solution.isPalindrome(l1));
        }

        {
            PalindromeLinkList solution = new PalindromeLinkList();
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(2);
            ListNode l4 = new ListNode(1);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            // true
            System.out.println(solution.isPalindrome(l1));
        }

        {
            PalindromeLinkList solution = new PalindromeLinkList();
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(3);
            ListNode l4 = new ListNode(1);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            // false
            System.out.println(solution.isPalindrome(l1));
        }

        {
            PalindromeLinkList solution = new PalindromeLinkList();
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(3);
            ListNode l4 = new ListNode(2);
            ListNode l5 = new ListNode(1);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l5;
            // true
            System.out.println(solution.isPalindrome(l1));
        }

    }

}
