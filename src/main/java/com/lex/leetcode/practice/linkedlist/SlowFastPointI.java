package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 简单
 *
 * @author lifeng
 */
public class SlowFastPointI {

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

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        {
            SlowFastPointI solution = new SlowFastPointI();
            ListNode l1 = new ListNode(2);
            ListNode l11 = new ListNode(4);
            ListNode l12 = new ListNode(3);
            l1.next = l11;
            l11.next = l12;

            System.out.println(solution.hasCycle(l1));
        }

        {
            SlowFastPointI solution = new SlowFastPointI();
            ListNode l1 = new ListNode(2);
            ListNode l11 = new ListNode(4);
            ListNode l12 = new ListNode(9);
            l1.next = l11;
            l11.next = l12;

            System.out.println(solution.hasCycle(l1));
        }

    }

}
