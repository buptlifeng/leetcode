package com.lex.leetcode.practice.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 * 中等
 *
 * @author lifeng
 */
public class MergeInBetweenLinkedList {

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

    public static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int n : arr) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int pre1 = a - 1, pre2 = b + 1;
        int step = 0;
        ListNode head = list1, ph1 = list1, ph2 = null;
        while (list1 != null && ph2 == null) {
            if (step == pre1) {
                ph1 = list1;
            } else if (step == pre2) {
                ph2 = list1;
            }
            step++;
            list1 = list1.next;
        }
        ph1.next = list2;

        ListNode tail = null;
        while (list2 != null) {
            tail = list2;
            list2 = list2.next;
        }
        tail.next = ph2;
        return head;
    }

    public static void main(String[] args) {
        {
            MergeInBetweenLinkedList solution = new MergeInBetweenLinkedList();
            ListNode h1 = build(new int[]{
                    0, 1, 2, 3, 4, 5
            });
            ListNode h2 = build(new int[]{
                    1000000, 1000001, 1000002
            });
            ListNode head = solution.mergeInBetween(h1, 3, 4, h2);
            System.out.println(head);
        }

        {
            MergeInBetweenLinkedList solution = new MergeInBetweenLinkedList();
            ListNode h1 = build(new int[]{
                    0, 1, 2, 3, 4, 5, 6
            });
            ListNode h2 = build(new int[]{
                    1000000, 1000001, 1000002, 1000003, 1000004
            });
            ListNode head = solution.mergeInBetween(h1, 2, 5, h2);
            System.out.println(head);
        }

    }

}
